/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unido.pidev.interfaces;

import unido.pidev.models.Annonces;
import unido.pidev.services.IService;


/**
 *
 * @author user
 */
public interface IAnnoncesService extends IService <Annonces,Integer>{
    public void addventeNeuve (Annonces a);
    
    
}
