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
import unido.pidev.interfaces.IMessage;
import unido.pidev.models.Message;
import unido.pidev.models.User;
import unido.pidev.techniques.DataSource;


/**
 *
 * @author Yousfi Oussama
 */

public class MessageService implements IMessage {
    
        Connection connection;
        
        public MessageService() throws SQLException {
            connection = DataSource.getInsatance().getConnection();
        }

// Envoyer message
    @Override
    public void add(Message t) {
         java.util.Date date_util = new java.util.Date();
         java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
try {
        String requete ="INSERT INTO messagerie(id_msg,id_user,id_user2,texte,date_envoi) VALUES (?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(requete);
         pst.setInt(1,t.getId_msg());
         pst.setInt(2,t.getUser1().getId());
         pst.setInt(3,t.getUser2().getId());
         pst.setString(4,t.getMessage());
         pst.setDate(5,date_sql);
         pst.executeUpdate();
         System.out.println("Insertion effectué avec succés");
         
        
    }  catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

  // supprimer message  
    @Override
    public void remove(Integer id) {
        String req = "delete from messagerie where id_msg =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

   // afficher tous les messages 
    @Override
    public List<Message> getAll() {
        List<Message> messages = new ArrayList<>();
        String req = "select * from messagerie";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Message message = new Message(resultSet.getInt("id_msg"),new UserService().findById(resultSet.getInt(2)),new UserService().findById(resultSet.getInt(3)), resultSet.getString(4), resultSet.getDate(5));
                messages.add(message);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return messages;
    }
    
// afficher les conversations
    @Override
    public List<Message> getConversationByUsersId(User u1, User u2) {
        List<Message> messages = new ArrayList<>();
        String req = "select * from messagerie where (id_user = ? AND id_user2 = ?) OR (id_user = ? AND id_user2 = ?) ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, u1.getId());
            preparedStatement.setInt(2, u2.getId());
            preparedStatement.setInt(3, u2.getId());
            preparedStatement.setInt(4, u1.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Message message = new Message(resultSet.getInt("id_msg"), new UserService().findById(resultSet.getInt(2)),new UserService().findById(resultSet.getInt(3)), resultSet.getString(4),resultSet.getDate(5));
                messages.add(message);
            }
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return messages;
    }

    @Override
    public List<String> GetConversationByUsersId(User u1, User u2) {
        List<String> messages = new ArrayList<>();
        String req = "select * from messagerie where (id_user = ? AND id_user2 = ?) OR (id_user = ? AND id_user2 = ?) ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, u1.getId());
            preparedStatement.setInt(2, u2.getId());
            preparedStatement.setInt(3, u2.getId());
            preparedStatement.setInt(4, u1.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String message = resultSet.getString(4);
                messages.add(message);
            }
             
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return messages;
    }
    
}
