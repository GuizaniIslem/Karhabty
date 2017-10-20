/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unido.pidev.services;





import unido.pidev.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import unido.pidev.models.Test_autoecole;
import unido.pidev.techniques.DataSource;
import unido.pidev.interfaces.ITest_autoecoleService;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Test_autoecoleService implements ITest_autoecoleService {

    Connection connection;

    public Test_autoecoleService () {
        connection = DataSource.getInsatance().getConnection();
    }

  
    
    public void add(Test_autoecole t) {
        String req = "insert into test_auto-ecole (id_test,id_user_fk,questions,reponses) values (?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getId_test());
            preparedStatement.setInt(2, t.getUser().getId());
            preparedStatement.setString(3, t.getQuestion());
            preparedStatement.setString(4, t.getReponses());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public void remove(Integer id_test) {
        String req = "delete from test_auto-ecole where id_test =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_test);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public void update(Test_autoecole t) {
        String req = "update test_auto-ecole set id_user_fk=?,questions=?, reponses=? where id_test = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getUser().getId());
            preparedStatement.setString(2, t.getQuestion());
            preparedStatement.setString(3, t.getReponses());
            preparedStatement.setInt(4, t.getId_test());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public List<Test_autoecole> getAll() {
        List<Test_autoecole> test_autoecoles = new ArrayList<>();
        String req = "select * from test_auto-ecole";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Test_autoecole test_autoecole = new Test_autoecole(resultSet.getInt("id_test") ,resultSet.getString(3), resultSet.getString(4) , new UserService().findById(resultSet.getInt(2)));
                test_autoecoles.add(test_autoecole);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return test_autoecoles;
    }

    

    public List<Test_autoecole> getByUser(User user) {
        List<Test_autoecole> test_autoecoles = new ArrayList<>();
        String req = "select * from test_auto-ecole where id_user_fk=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Test_autoecole test_autoecole = new Test_autoecole(resultSet.getInt("id_test") ,resultSet.getString(3), resultSet.getString(4) , new UserService().findById(resultSet.getInt(2)));
                test_autoecoles.add(test_autoecole);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return test_autoecoles;
    }

    
    public Test_autoecole findById(Integer id_test) {
        Test_autoecole test_autoecole = null;
        String req = "select * from test_auto-ecole where id_test =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_test);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                test_autoecole = new Test_autoecole(resultSet.getInt("id_test") ,resultSet.getString(3), resultSet.getString(4) ,  new UserService().findById(resultSet.getInt(2)) );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return test_autoecole;
    }
}


