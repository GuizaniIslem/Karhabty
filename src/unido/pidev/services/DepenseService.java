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
import unido.pidev.interfaces.IDepenseService;
import unido.pidev.models.Depense;
import unido.pidev.models.voiture;
import unido.pidev.techniques.DataSource;

/**
 * 
 * @author Nourelhouda 
 */
public class DepenseService implements IDepenseService {

     Connection connection ; 
       
    public DepenseService() {
        connection = DataSource.getInsatance().getConnection(); 
    }
    
    //@Override
    public void add( Depense t) {
        String req = "insert into depenses ( id_voiture, type,cout,date) values (?,?,?,?) " ;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getVoiture().getId_voiture()); 
                         
            preparedStatement.setString(2, t.getType());
            preparedStatement.setInt(3, t.getCout());
                       try {  
            preparedStatement.setDate(4, t.convert(t.getDate()) );
            
                } catch (ParseException ex) {
                    Logger.getLogger(DepenseService.class.getName()).log(Level.SEVERE, null, ex);
                }

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace();  
        }
    }

    public void update(Depense t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remove(Integer r) {
       String req = "delete from depense where id_depense =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }

    public Depense findById(Integer r) {
        Depense depense = null;
        String req = "select * from depenses where id_depense =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                depense = new Depense (resultSet.getInt("id_depense"), resultSet.getString("type"),(resultSet.getInt("cout")),resultSet.getString("date")); 
            }
        } catch (SQLException ex) {
        }
        return depense;
    }

    public List<Depense> getAll() {
       List<Depense> depenses = new ArrayList<>();
        String req = "select * from depenses ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               Depense d = new Depense (resultSet.getInt("id_depense"), resultSet.getString("type"),(resultSet.getInt("cout")),resultSet.getString("date") );
                depenses.add(d); 
            }
        } catch (SQLException ex) {
        }
        return depenses ;
    }
    
    public List<Depense> getAllById(int id ) {
       List<Depense> depenses = new ArrayList<>();
        String req = "select * from depenses where id_voiture=? ";
        PreparedStatement preparedStatement;
        
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               Depense d = new Depense (resultSet.getInt("id_depense"), resultSet.getString("type"),(resultSet.getInt("cout")),resultSet.getString("date") );
                depenses.add(d); 
            }
        } catch (SQLException ex) {
        }
        return depenses ;
    }

}
