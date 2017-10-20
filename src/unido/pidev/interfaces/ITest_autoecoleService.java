/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unido.pidev.interfaces;
import unido.pidev.models.Test_autoecole;
import unido.pidev.models.User;

import java.util.List;
/**
 *
 * @author MALEK
 */
public interface ITest_autoecoleService extends Iservice<Test_autoecole, Integer> {
     List<Test_autoecole> getByUser(User user);
}