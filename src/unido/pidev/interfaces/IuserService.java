/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unido.pidev.interfaces;

import java.util.List;
import unido.pidev.models.User;

/**
 *
 * @author Mariem
 */
public interface IuserService extends Iservice <User, Integer> {

   
    void remove(User u);
    public User findById (int id);
   
    
}
