/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unido.pidev.interfaces;

import java.util.List;
import unido.pidev.models.Message;
import unido.pidev.models.User;

/**
 *
 * @author Mariem
 */
public interface IMessage {
    void add(Message m);
    void remove(Integer r);
    List<Message> getConversationByUsersId(User u1,User u2);
    public List<String> GetConversationByUsersId(User u1, User u2);
    public List<Message> getAll();
}
