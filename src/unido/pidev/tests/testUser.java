package unido.pidev.tests;

import java.sql.SQLException;
import unido.pidev.interfaces.IuserService;
import unido.pidev.models.User;
import unido.pidev.services.UserService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mariem
 */
public class testUser {
    
    public static void main(String[] args) throws SQLException {
    User u = new User ("Mariem","Hasnaoui",14253140,"mariem.hasnaoui@esprit.tn",92339150,"mimi","123456","admin"); 
    User u2 = new User ("Mimi","Hasnaoui",14253140,"mariem.hasnaoui@esprit.tn",92339150,"mimi","123456","admin");   

    IuserService userService=new UserService();
    //userService.add(u);
    //userService.add(u2);

    //Conversation conv = new Conversation ("azes",u,u2);
    //Message M = new Message ("ghjk",conv);
   // MessageService.envoyer(M);
    
    
    
}
    
}
