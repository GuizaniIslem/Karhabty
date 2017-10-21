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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import unido.pidev.interfaces.IVoitureService;
import unido.pidev.models.User;
import unido.pidev.models.voiture;

import unido.pidev.techniques.DataSource;


/**
 * 
 * @author Nourelhouda 
 */
public class VoitureService implements IVoitureService{
    Connection connection ; 
       
    public VoitureService() {
        connection = DataSource.getInsatance().getConnection(); 
    }

    @Override
    public void add( voiture t) {
        String req = "insert into voitures ( id_user,marque, matricule, date_vignette,date_visite,date_assurance,date_vidange) values (?,?,?,?,?,?,?) " ;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            //preparedStatement.setInt(1, t.getId_voiture());
            preparedStatement.setInt(1, t.getUser().getId());              //à verifier
            preparedStatement.setString(2, t.getMarque());
            preparedStatement.setString(3, t.getMatricule());
                       try {  
            preparedStatement.setDate(4, t.convert(t.getDate_vignette()) );
            preparedStatement.setDate(5, t.convert(t.getDate_visite()));
            preparedStatement.setDate(6,t.convert(t.getDate_assurance()));
            preparedStatement.setDate(7, t.convert(t.getDate_vidange()));
                } catch (ParseException ex) {
                    Logger.getLogger(VoitureService.class.getName()).log(Level.SEVERE, null, ex);
                }

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace();  
        }
    }

    @Override
    public void update(voiture t) {
       String req = "update voitures set marque=?, matricule=? , date_vignette=? ,date_visite=? ,date_assurance=? ,date_vidange=? where id_voiture = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            //preparedStatement.setInt(1, t.getUser().getId_user());
           
            preparedStatement.setString(1, t.getMarque());
            preparedStatement.setString(2, t.getMatricule());
           try {  
               preparedStatement.setDate(3, t.convert(t.getDate_vignette()) );
           
            preparedStatement.setDate(4, t.convert(t.getDate_vignette()));
            preparedStatement.setDate(5,t.convert(t.getDate_assurance()));
            preparedStatement.setDate(6, t.convert(t.getDate_vidange()));
            } catch (ParseException ex) {
               Logger.getLogger(VoitureService.class.getName()).log(Level.SEVERE, null, ex);
           }
           preparedStatement.setInt(7, t.getId_voiture());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace()  ;  
        }
    }
    

    @Override
    public void remove(Integer id) {
       String req = "delete from voitures where id_voiture =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public void removeAll(){
         String req = "delete from voitures ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public voiture findById(Integer r) {
      voiture voiture = null;
        String req = "select * from voitures where id_voiture =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                voiture = new voiture (resultSet.getInt("id_voiture"), new UserService().findById(resultSet.getInt(2)), resultSet.getString("marque"),resultSet.getString("matricule"));
            }
        } catch (SQLException ex) {
        }
        return voiture;
    }

    @Override
    public List<voiture> getAll() {
        List<voiture> cars = new ArrayList<>();
        String req = "select * from voitures ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               voiture car = new voiture (resultSet.getInt("id_voiture"), new UserService().findById(resultSet.getInt(2)), resultSet.getString("marque"),resultSet.getString("matricule") );
                cars.add(car); 
            }
        } catch (SQLException ex) {
        }
        return cars ;
    }

    @Override
    public List<voiture> getByUser(User user) {
           List<voiture> cars = new ArrayList<>();
        String req = "select * from voitures where id_user=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, user.getId());              //à verifier
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                voiture car = new voiture (resultSet.getInt("id_voiture"), new UserService().findById(resultSet.getInt(2)), resultSet.getString("marque"),resultSet.getString("matricule"));
                cars.add(car);
            }
        } catch (SQLException ex) {
        }
        return cars;
    }


}
