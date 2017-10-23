/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unido.pidev.services;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import unido.pidev.interfaces.IAnnoncesService;
import unido.pidev.models.Annonces;
import unido.pidev.techniques.DataSource;

/**
 *
 * @author user
 */
public class AnnoncesService implements IAnnoncesService{
Connection connection;

    public AnnoncesService() {
        connection = DataSource.getInsatance().getConnection();
    }

   
 
//Modifier Annonces
    @Override
    public void update(Annonces a) {
      String req = "update annonces set titre=?,categorie=?,ville=?,description=?,prix=?,date=?,region=?,type=?,garantie=?,nbre_places=?,nbre_portes=?,energie=?,nbre_cylindres=?,puissance=?,consomation_mixte=?,vitesse_max=?,performance=?,connectivite=?,Adresse=?,Kilometrage=?,année=?,mise_circulation=?,num_tel=? where id_annonce = ?";
         PreparedStatement preparedStatement;
          java.util.Date date_util = new java.util.Date();
        //java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        java.sql.Date date_sql = new java.sql.Date(a.getDate().getTime());
        try {
          preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1,a.getTitre());
            preparedStatement.setString(2,a.getCategorie());
            preparedStatement.setString(3,a.getVille());
            preparedStatement.setString(4,a.getDescription());
            preparedStatement.setFloat(5,a.getPrix());
            preparedStatement.setDate(6,date_sql);
            preparedStatement.setString(7,a.getRegion());
            preparedStatement.setString(8,a.getType());
            preparedStatement.setInt(9,a.getGarantie());
            preparedStatement.setInt(10,a.getNbre_places());
            preparedStatement.setInt(11,a.getNbre_portes());
            preparedStatement.setString(12,a.getEnergie());
            preparedStatement.setInt(13,a.getNbre_cylindres());
            preparedStatement.setInt(14,a.getPuissance());
            preparedStatement.setFloat(15,a.getConsomation_mixte());
            preparedStatement.setInt(16,a.getVitesse_max());
            preparedStatement.setInt(17,a.getPerformance());
            preparedStatement.setBoolean(18,a.isConnectivite());
            preparedStatement.setString(19,a.getAdresse());
            preparedStatement.setInt(20,a.getKilometrage());
            preparedStatement.setInt(21,a.getAnnée());
            preparedStatement.setDate(22,date_sql);
            preparedStatement.setInt(23,a.getNum_tel());
             preparedStatement.setInt(24,a.getId_annonces());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Supprimer Annonce
    @Override
    public void remove(Integer id) {
        String req = "delete from annonces where id_annonce=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
//recherche par l id
    @Override
    public Annonces findById(Integer r) {
            Annonces annonce = null;
        String req = "select * from annonces where id_annonce =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1,r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
         annonce = new Annonces(resultSet.getInt("id_annonce"), resultSet.getString("titre"), resultSet.getString("categorie"),resultSet.getString("ville"),resultSet.getString("description"),resultSet.getFloat("prix"),resultSet.getDate("date"),resultSet.getString("region"),resultSet.getString("type"),resultSet.getInt("garantie"),resultSet.getInt("nbre_places"),resultSet.getInt("nbre_portes"),resultSet.getString("energie"), (int) resultSet.getFloat("nbre_cylindres"),resultSet.getInt("puissance"),resultSet.getInt("consomation_mixte"),resultSet.getInt("vitesse_max"),resultSet.getInt("performance"),resultSet.getBoolean("connectivite"),resultSet.getString("Adresse"),resultSet.getInt("kilometrage"),resultSet.getInt("année"),resultSet.getDate("mise_circulation"),resultSet.getInt("num_tel"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return annonce;
    }
    
// affichage de tous les annonces 
    @Override
    public List<Annonces> getAll() {
          List<Annonces> annonces = new ArrayList<>();
        String req = "select * from annonces";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            Annonces annonce = new Annonces(resultSet.getInt("id_annonce"), resultSet.getString("titre"), resultSet.getString("categorie"),resultSet.getString("ville"),resultSet.getString("description"),resultSet.getFloat("prix"),resultSet.getDate("date"),resultSet.getString("region"),resultSet.getString("type"),resultSet.getInt("garantie"),resultSet.getInt("nbre_places"),resultSet.getInt("nbre_portes"),resultSet.getString("energie"), (int) resultSet.getFloat("nbre_cylindres"),resultSet.getInt("puissance"),resultSet.getInt("consomation_mixte"),resultSet.getInt("vitesse_max"),resultSet.getInt("performance"),resultSet.getBoolean("connectivite"),resultSet.getString("Adresse"),resultSet.getInt("kilometrage"),resultSet.getInt("année"),resultSet.getDate("mise_circulation"),resultSet.getInt("num_tel"));
            annonces.add(annonce);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return annonces;   
    }
   //Ajouter Annonce
    @Override
    public void addventeNeuve(Annonces a) {
        String req = "insert into annonces (titre,categorie,ville,description,prix,date,region,type,garantie,nbre_places,nbre_portes,energie,nbre_cylindres,puissance,consomation_mixte,vitesse_max,performance,connectivite,Adresse,Kilometrage,année,mise_circulation,num_tel) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        java.util.Date date_util = new java.util.Date();
        //java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
        java.sql.Date date_sql = new java.sql.Date(a.getDate().getTime());
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1,a.getTitre());
            preparedStatement.setString(2,a.getCategorie());
            preparedStatement.setString(3,a.getVille());
            preparedStatement.setString(4,a.getDescription());
            preparedStatement.setFloat(5,a.getPrix());
            preparedStatement.setDate(6,date_sql);
            preparedStatement.setString(7,a.getRegion());
            preparedStatement.setString(8,a.getType());
            preparedStatement.setInt(9,a.getGarantie());
            preparedStatement.setInt(10,a.getNbre_places());
            preparedStatement.setInt(11,a.getNbre_portes());
            preparedStatement.setString(12,a.getEnergie());
            preparedStatement.setInt(13,a.getNbre_cylindres());
            preparedStatement.setInt(14,a.getPuissance());
            preparedStatement.setFloat(15,a.getConsomation_mixte());
            preparedStatement.setInt(16,a.getVitesse_max());
            preparedStatement.setInt(17,a.getPerformance());
            preparedStatement.setBoolean(18,a.isConnectivite());
            preparedStatement.setString(19,a.getAdresse());
            preparedStatement.setInt(20,a.getKilometrage());
            preparedStatement.setInt(21,a.getAnnée());
            preparedStatement.setDate(22,date_sql);
            preparedStatement.setInt(23,a.getNum_tel());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    
    
}
