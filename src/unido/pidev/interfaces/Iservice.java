/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unido.pidev.interfaces;

import java.util.List;

/**
 *
 * @author Mariem
 * @param <T>
 * @param <R>
 */
public interface Iservice<T, R> {

    void add(T t);

    void update(T t);

    void remove(R r);

    T findById(R r);

    List<T> getAll();
    
   
}
