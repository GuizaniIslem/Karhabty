package unido.pidev.tests;

import java.sql.SQLException;
import unido.pidev.interfaces.IuserService;
import unido.pidev.models.Message;
import unido.pidev.models.Pub;
import unido.pidev.models.User;
import unido.pidev.models.voiture;
import unido.pidev.services.MessageService;

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
    User u = new User ("Mariem","Hasnaoui",14253140,"mariem.hasnaoui@esprit.tn",92339150,"MariemH","123456","Client"); 
    User u2 = new User ("Oussema","Youssfi",14253140,"oussema.youssfi@esprit.tn",92339150,"OussemaY","123456","Client");   
    User u3 = new User ("Mimi","Hafnaoui",14253140,"mariem.hafnaoui@esprit.tn",92339150,"mimi","123456","admin");

    IuserService userService=new UserService();
    userService.add(u);
    userService.add(u2);
    userService.add(u3);
     for (User u : u .getAll()) {
            System.out.println(u);
    }
    

   
   /* Message m = new Message(u, u2, "Salut !, Comment ça va ? je vous parle à propos de la fiat 500 , quel age a-elle ?");
    MessageService M = new MessageService();
    M.add(m);
    Message m1 = new Message(u2, u, "Bonjour ! oui parfait , elle a 3 ans");
    M.add(m1);
    Message m2 = new Message(u, u3, "Salut u3 !");
    M.add(m2);
    Message m3 = new Message(u3, u, "bonjour u !");
    M.add(m3);
     
    for (String s : M.GetConversationByUsersId(u, u3)) {
            System.out.println(s);
        }
    System.out.println("************************");
    for (Message message : M.getAll()) {
            System.out.println(message);
    }*/
    
   ///////////////TEST VOITURE \\\\\\\\\\\\\\\\\
   VoitureService vs = new VoitureService() ; 
    voiture v1= new voiture (3,u,"peujeot","123Tun4430","2/12/2012","12/12/2012", "12/12/2012","12/12/2012") ;
    //vs.add(v1); 
    
    
    ///////////TEST PUB \\\\\\\\\\\\\\\
    PubService ps = new PubService() ;
    Pub p = new Pub(1,u,"titre1","desc1","15/10/2017","path1") ;
    ps.add(p);
    
    
}
    
}
