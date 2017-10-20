/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unido.pidev.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import unido.pidev.interfaces.IuserService;
import unido.pidev.models.User;
import unido.pidev.techniques.DataSource;

/**
 *
 * @author Mariem
 */
public class UserService implements IuserService {
    Connection connection;

    public UserService() throws SQLException {
        connection = DataSource.getInsatance().getConnection();
    }
   
    @Override
    public void add(User u) {
        try {
              System.out.println(u.toString());
              String requete ="INSERT INTO users (nom,prenom,CIN,mail,telephone,adresse,login,MDP,pièce_permission,role) VALUES (?,?,?,?,?,?,?,?,?,?)";
              PreparedStatement pst = connection.prepareStatement(requete);
              pst.setString(1, u.getNom());
              pst.setString(2, u.getPrenom());
              pst.setLong(3, u.getCIN());
              pst.setString(4, u.getMail());
              pst.setLong(5, u.getTelephone());
              pst.setString(6, u.getAdresse());
              pst.setString(7, u.getLogin());
              pst.setString(8, u.getMdp());
              pst.setString(9, u.getPiece_permission());
              pst.setString(10, u.getRole());

              pst.executeUpdate();
              System.out.println("Insertion effectué avec succés");
            } catch (SQLException ex) {
                    ex.printStackTrace();
                }    
    }

    @Override
    public void update(User u) {
        try {
              System.out.println(u.toString());
                    String requete ="update users set nom=?,prenom=?CIN=?mail=?telephone=?adresse=?login=?MDP=?pièce_permission=?role=? VALUES (?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement pst = connection.prepareStatement(requete);
                    pst.setString(1, u.getNom());
                    pst.setString(2, u.getPrenom());
                    pst.setLong(3, u.getCIN());
                    pst.setString(4, u.getMail());
                    pst.setLong(5, u.getTelephone());
                    pst.setString(6, u.getAdresse());
                    pst.setString(7, u.getLogin());
                    pst.setString(8, u.getMdp());
                    pst.setString(9, u.getPiece_permission());
                    pst.setString(10, u.getRole());

                    pst.executeUpdate();
                    System.out.println("Modification effectué avec succés");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
    }


    @Override
    public void remove(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @Override
    public User findById (int id) {
        User user = null;
        String req = "select * from users where id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User( resultSet.getInt("id"),
                        resultSet.getString("nom"), 
                        resultSet.getString("prenom"),
                        resultSet.getLong("CIN"),
                        resultSet.getString("mail"),
                        resultSet.getLong("telephone"),
                        resultSet.getString("adresse"),
                        resultSet.getString("Login"),
                        resultSet.getString("mdp"),
                        resultSet.getString("piece_permission"),
                        resultSet.getString("role") );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
          }

    @Override
    public void remove(User u) {
        try {
            String requete="delete from users where id=?";
            PreparedStatement ps = connection.prepareStatement(requete);
            
            ps.setInt(1, u.getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }


    @Override
    public List<User> getAll() {
           List<User> user =  new ArrayList<>();
        String req = "select * from users";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User  u = new User( resultSet.getInt("id"),
                        resultSet.getString("nom"), 
                        resultSet.getString("prenom"),
                        resultSet.getLong("CIN"),
                        resultSet.getString("mail"),
                        resultSet.getLong("telephone"),
                        resultSet.getString("adresse"),
                        resultSet.getString("Login"),
                        resultSet.getString("mdp"),
                        resultSet.getString("piece_permission"),
                        resultSet.getString("role") );
                        user.add(u); 

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public User findById(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
}
