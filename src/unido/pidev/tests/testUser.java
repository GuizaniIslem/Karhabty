package unido.pidev.tests;

import java.sql.SQLException;
import unido.pidev.interfaces.IuserService;
import unido.pidev.models.Pub;
import unido.pidev.models.User;
import unido.pidev.models.Voiture;
import unido.pidev.services.PubService;
import unido.pidev.services.UserService;
import unido.pidev.services.VoitureService;

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
    userService.add(u);
    //userService.add(u2);

    //Conversation conv = new Conversation ("azes",u,u2);
    //Message M = new Message ("ghjk",conv);
   // MessageService.envoyer(M);
    
   
   ///////////////TEST VOITURE \\\\\\\\\\\\\\\\\
   VoitureService vs = new VoitureService() ; 
    Voiture v1= new Voiture (3,u,"peujeot","123Tun4430","2/12/2012","12/12/2012", "12/12/2012","12/12/2012") ;
    //vs.add(v1); 
    
    
    ///////////TEST PUB \\\\\\\\\\\\\\\
    PubService ps = new PubService() ;
    Pub p = new Pub(1,u,"titre1","desc1","15/10/2017","path1") ;
    ps.add(p);
    
    
}
    
}
