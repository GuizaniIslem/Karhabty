/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unido.pidev.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Nourelhouda
 */
public class voiture {

   private int id_voiture;
    private User user;
    private String marque;
    private String matricule;

    private String date_vignette;
    private String date_visite;
    private String date_assurance;
    private String date_vidange;
    private String date_mc ; 
    private int kilometrage_actuel ; 
    
   
    

    public voiture(int id_voiture, User user, String marque, String matricule, String date_vignette, String date_visite, String date_assurance, String date_vidange) {
        this.id_voiture = id_voiture;
        this.user = user;
        this.marque = marque;
        this.matricule = matricule;
        this.date_vignette = date_vignette;
        this.date_visite = date_visite;
        this.date_assurance = date_assurance;
        this.date_vidange = date_vidange;
    }

    public voiture(int id_voiture, User user, String marque, String matricule) {
        this.id_voiture = id_voiture;
        this.user = user;
        this.marque = marque;
        this.matricule = matricule;
    }

    public voiture() {
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public User getUser() {
        return user;
    }

    public String getDate_mc() {
        return date_mc;
    }

    public int getKilometrage_actuel() {
        return kilometrage_actuel;
    }

    
    

    public void setUser(User user) {
        this.user = user;
    }

    public void setDate_mc(String date_mc) {
        this.date_mc = date_mc;
    }

    public void setKilometrage_actuel(int kilometrage_actuel) {
        this.kilometrage_actuel = kilometrage_actuel;
    }


    
    
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDate_vignette() {
        return date_vignette;
    }

    public void setDate_vignette(String date_vignette) {
        this.date_vignette = date_vignette;
    }

    public String getDate_visite() {
        return date_visite;
    }

    public void setDate_visite(String date_visite) {
        this.date_visite = date_visite;
    }

    public String getDate_assurance() {
        return date_assurance;
    }

    public void setDate_assurance(String date_assurance) {
        this.date_assurance = date_assurance;
    }

    public String getDate_vidange() {
        return date_vidange;
    }

    public void setDate_vidange(String date_vidange) {
        this.date_vidange = date_vidange;
    }

    @Override
    public String toString() {
        return "voiture{" + "id_voiture=" + id_voiture + ", user=" + user + ", marque=" + marque + ", matricule=" + matricule + ", date_vignette=" + date_vignette + ", date_visite=" + date_visite + ", date_assurance=" + date_assurance + ", date_vidange=" + date_vidange + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final voiture other = (voiture) obj;
        if (this.id_voiture != other.id_voiture) {
            return false;
        }
        return true;
    }
    
    
    

    public java.sql.Date convert(String date) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date1 = sdf1.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());

        
        return sqlDate;
    }

}
