/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unido.pidev.models;

import java.util.Objects;

/**
 *
 * @author Mariem
 */
public class User {
    public int id ;
    private String nom ;
    private String prenom ;
    private long CIN ; 
    private String mail ;
    private long telephone ;
    private String adresse ;
    private String login ;
    private String mdp ;
    private String piece_permission ;
    private String role ;

    public User( int id , String nom, String prenom, long CIN, String mail, long telephone, String login, String mdp , String role) {
        this.id = id ;
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.mail = mail;
        this.telephone = telephone;
        this.login = login;
        this.mdp = mdp;
        this.role = role;
    }

    public User( int id , String nom, String prenom, long CIN, String mail, long telephone, String adresse, String login, String mdp, String piece_permission, String role) {
        this.id = id ;
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.mail = mail;
        this.telephone = telephone;
        this.adresse = adresse;
        this.login = login;
        this.mdp = mdp;
        this.piece_permission = piece_permission;
        this.role = role;
    }
     public User(  String nom, String prenom, long CIN, String mail, long telephone, String adresse, String login, String mdp, String piece_permission, String role) {
       
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.mail = mail;
        this.telephone = telephone;
        this.adresse = adresse;
        this.login = login;
        this.mdp = mdp;
        this.piece_permission = piece_permission;
        this.role = role;
    }
     
     public User(  String nom, String prenom, long CIN, String mail, long telephone,String login, String mdp, String role) {
       
        this.nom = nom;
        this.prenom = prenom;
        this.CIN = CIN;
        this.mail = mail;
        this.telephone = telephone;
        this.login = login;
        this.mdp = mdp;
        this.role = role;
    }
     

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public long getCIN() {
        return CIN;
    }

    public void setCIN(long CIN) {
        this.CIN = CIN;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPiece_permission() {
        return piece_permission;
    }

    public void setPiece_permission(String piece_permission) {
        this.piece_permission = piece_permission;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        final User other = (User) obj;
        
        if (this.id != other.id) {
            return false;
        }
        return true ;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", CIN=" + CIN + ", mail=" + mail + ", telephone=" + telephone + ", adresse=" + adresse + ", login=" + login + ", mdp=" + mdp + ", piece_permission=" + piece_permission + ", role=" + role + '}';
    }

    
    
    
    
}
