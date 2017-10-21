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
import unido.pidev.interfaces.INotesVoitureService;
import unido.pidev.models.Depense;
import unido.pidev.models.NotesVoiture;
import unido.pidev.techniques.DataSource;

/**
 * 
 * @author Nourelhouda 
 */
public class NotesVoitureService implements INotesVoitureService {
    
    Connection connection ; 
       
    public NotesVoitureService() {
        connection = DataSource.getInsatance().getConnection(); 
    }
 

    @Override
    public void add(NotesVoiture t) {
        String req = "insert into notes ( id_voiture, date_note , objet, details) values (?,?,?,?) " ;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getVoiture().getId_voiture()); 
                         
            try {
                preparedStatement.setDate(2,(t.convert(t.getDate_notes() ))) ;
            } catch (ParseException ex) {
                Logger.getLogger(NotesVoitureService.class.getName()).log(Level.SEVERE, null, ex);
            }
            preparedStatement.setString(3, t.getObjet());
                       
            preparedStatement.setString(4, t.getDetails() );
            

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace();  
        }
    }

    @Override
    public void update(NotesVoiture t) {
        String req = "update notes set  date_notes=? , objet=? , details=?  where id_voiture = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            //preparedStatement.setInt(1, t.getUser().getId_user());
           
             preparedStatement = connection.prepareStatement(req);
             
            preparedStatement.setInt(4, t.getVoiture().getId_voiture()); 
                         
            try {
                preparedStatement.setDate(1,(t.convert(t.getDate_notes() ))) ;
            } catch (ParseException ex) {
                Logger.getLogger(NotesVoitureService.class.getName()).log(Level.SEVERE, null, ex);
            }
            preparedStatement.setString(2, t.getObjet());
                       
            preparedStatement.setString(3, t.getDetails() ); 

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
             ex.printStackTrace()  ;  
        }
    }

    @Override
    public void remove(Integer r) {
        String req = "delete from notes where id_note =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public NotesVoiture findById(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotesVoiture> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public List<NotesVoiture> getAllById(int id ) {
       List<NotesVoiture> list = new ArrayList<>();
        String req = "select * from notes where id_voiture=? ";
        PreparedStatement preparedStatement;
        
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               NotesVoiture d = new NotesVoiture (resultSet.getInt("id_notes"), resultSet.getString("date_note"),(resultSet.getString("objet")),resultSet.getString("details") );
                list.add(d); 
            }
        } catch (SQLException ex) {
        }
        return list ;
    }

}
