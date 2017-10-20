/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unido.pidev.services;



import unido.pidev.models.Reclamation;
import unido.pidev.models.User;
import unido.pidev.techniques.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import unido.pidev.interfaces.IReclamationService;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ReclamationService implements IReclamationService {

    Connection connection;

    public ReclamationService() {
        connection = DataSource.getInsatance().getConnection();
    }

    
    
    public void add(Reclamation r) {
        String req = "insert into reclamation (id_reclamation,users_fk,sujet,description,date) values (?,?,?,?,?)";
        PreparedStatement preparedStatement;
        java.util.Date date = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date.getTime());
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r.getId_reclamation());
            preparedStatement.setInt(2, r.getUser().getId());
            preparedStatement.setString(3, r.getSujet());
            preparedStatement.setString(4, r.getDescription());
            preparedStatement.setDate(5, date_sql);
           /* try {  
             preparedStatement.setDate(5, r.convert(r.getDate())) ;
           } catch (ParseException ex) {
               Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
           }*/
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    
    
    @Override
    public void remove(Integer id_reclamation) {
        String req = "delete from reclamation where id_reclamation =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_reclamation);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
  
    public void update(Reclamation r) {
        String req = "update reclamation set users_fk=?,sujet=?,description=?,date=?  where id_reclamation = ?";
        PreparedStatement preparedStatement;
        java.util.Date date = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date.getTime());
        try {
            preparedStatement = connection.prepareStatement(req);
               preparedStatement.setInt(1, r.getId_reclamation());
            preparedStatement.setInt(2, r.getUser().getId());
            preparedStatement.setString(3, r.getSujet());
            preparedStatement.setString(4, r.getDescription());
            preparedStatement.setDate(5, date_sql);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    

    
    public List<Reclamation> getAll() {
        List<Reclamation> reclamations = new ArrayList<>();
        String req = "select * from reclamation";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reclamation reclamation;
                reclamation = new Reclamation(resultSet.getInt("id_reclamation"),resultSet.getString(3),resultSet.getString(4),resultSet.getDate(5),  new UserService().findById(resultSet.getInt(2)) );
                reclamations.add(reclamation);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reclamations;
    }


    
    public List<Reclamation> getByUser(User user) {
        List<Reclamation> reclamations = new ArrayList<>();
       String req = "select * from reclamation where users_fk=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Reclamation reclamation;
                reclamation = new Reclamation(resultSet.getInt("id_reclamation"),resultSet.getString(3),resultSet.getString(4),resultSet.getDate(5),  new UserService().findById(resultSet.getInt(2)) );
                reclamations.add(reclamation);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reclamations;
    }
   
    
    @Override
    public Reclamation findById(Integer id_reclamation) {
       Reclamation reclamation = null;
        String req = "select * from reclamation where id_reclamation =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_reclamation);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 
                reclamation = new Reclamation(resultSet.getInt("id_reclamation"),resultSet.getString(3),resultSet.getString(4),resultSet.getDate(5),  new UserService().findById(resultSet.getInt(2)) );
                 }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return reclamation;
     
    }
}