/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unido.pidev.interfaces;
import unido.pidev.models.Reclamation;
import unido.pidev.models.User;

import java.util.List;
/**
 *
 * @author MALEK
 */
public interface IReclamationService extends Iservice<Reclamation, Integer> {
     List<Reclamation> getByUser(User user);
}
