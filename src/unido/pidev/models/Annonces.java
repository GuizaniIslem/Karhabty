/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unido.pidev.models;

import java.util.Date;

/**
 *
 * @author user
 */
public class Annonces {
    //Declaration des attributs
    private int id_annonces;
    private String titre;
    private String categorie;
    private String ville;
    private String description;
    private float prix;
    private Date date;
    private String region;
    private String type;
    private int garantie;
    private int nbre_portes;
    private String Energie;
    private int nbre_cylindres;
    private int puissance;
    private float consomation_mixte;
    private int vitesse_max;
    private int performance;
    private int nbre_places;
    private boolean connectivite;
    private String Adresse;
    private int kilometrage;
    private int année;
    private Date mise_circulation;
    private int num_tel;
    

    //constructeur par defaut

    public Annonces() {
    }
    
    //constructeur pour vente voiture neuve
  public Annonces(int id_annonce, String titre, String categorie, String ville, String description, float prix, Date date, String region, String type, int garantie,int nbre_places ,int nbre_portes, String Energie, int nbre_cylindres, int puissance, float consomation_mixte, int vitesse_max, int performance, boolean connectivite, int année) {
        this.id_annonces=id_annonce;
      this.titre = titre;
        this.categorie = categorie;
        this.ville = ville;
        this.description = description;
        this.prix = prix;
        this.date = date;
        this.region = region;
        this.type = type;
        this.garantie = garantie;
        this.nbre_portes = nbre_portes;
        this.Energie = Energie;
        this.nbre_cylindres = nbre_cylindres;
        this.puissance = puissance;
        this.consomation_mixte = consomation_mixte;
        this.vitesse_max = vitesse_max;
        this.performance = performance;
        this.nbre_places = nbre_places;
        this.connectivite = connectivite;
        this.année = année;
    }
    
    public Annonces( String titre, String categorie, String ville, String description, float prix, Date date, String region, String type, int garantie,int nbre_places ,int nbre_portes, String Energie, int nbre_cylindres, int puissance, float consomation_mixte, int vitesse_max, int performance, boolean connectivite, int année) {
        this.titre = titre;
        this.categorie = categorie;
        this.ville = ville;
        this.description = description;
        this.prix = prix;
        this.date = date;
        this.region = region;
        this.type = type;
        this.garantie = garantie;
        this.nbre_portes = nbre_portes;
        this.Energie = Energie;
        this.nbre_cylindres = nbre_cylindres;
        this.puissance = puissance;
        this.consomation_mixte = consomation_mixte;
        this.vitesse_max = vitesse_max;
        this.performance = performance;
        this.nbre_places = nbre_places;
        this.connectivite = connectivite;
        this.année = année;
    }
    
     //constructeur pour vente voiture occasion  + voiture collection 

    public Annonces(int id_annonces, String titre, String categorie, String ville, String description, float prix, Date date, String region, String type, int nbre_portes, String Energie, int nbre_cylindres, int puissance, float consomation_mixte, int vitesse_max, int performance, int nbre_places, boolean connectivite, int kilometrage, int année, Date mise_circulation, int num_tel) {
        this.id_annonces = id_annonces;
        this.titre = titre;
        this.categorie = categorie;
        this.ville = ville;
        this.description = description;
        this.prix = prix;
        this.date = date;
        this.region = region;
        this.type = type;
        this.nbre_portes = nbre_portes;
        this.Energie = Energie;
        this.nbre_cylindres = nbre_cylindres;
        this.puissance = puissance;
        this.consomation_mixte = consomation_mixte;
        this.vitesse_max = vitesse_max;
        this.performance = performance;
        this.nbre_places = nbre_places;
        this.connectivite = connectivite;
        this.kilometrage = kilometrage;
        this.année = année;
        this.mise_circulation = mise_circulation;
        this.num_tel = num_tel;
    }
    
    //constructeur vente piece de rechange
      public Annonces(int id_annonces, String titre, String categorie, String ville, String description, float prix, Date date, String region, String type, int garantie, int num_tel) {
        this.id_annonces = id_annonces;
        this.titre = titre;
        this.categorie = categorie;
        this.ville = ville;
        this.description = description;
        this.prix = prix;
        this.date = date;
        this.region = region;
        this.type = type;
        this.garantie = garantie;
        this.num_tel = num_tel;
    }
    
    //constructeur Location voiture + offre auto_ecole

    public Annonces(int id_annonces, String titre, String categorie, String ville, String description, float prix, Date date, String region, String type, String Adresse, int num_tel) {
        this.id_annonces = id_annonces;
        this.titre = titre;
        this.categorie = categorie;
        this.ville = ville;
        this.description = description;
        this.prix = prix;
        this.date = date;
        this.region = region;
        this.type = type;
        this.Adresse = Adresse;
        this.num_tel = num_tel;
    }

    public Annonces(int id_annonces, String titre, String categorie, String ville, String description, float prix, Date date, String region, String type, int garantie,int nbre_places, int nbre_portes, String Energie, int nbre_cylindres, int puissance, float consomation_mixte, int vitesse_max, int performance, boolean connectivite, String Adresse, int kilometrage, int année, Date mise_circulation, int num_tel) {
        this.id_annonces = id_annonces;
        this.titre = titre;
        this.categorie = categorie;
        this.ville = ville;
        this.description = description;
        this.prix = prix;
        this.date = date;
        this.region = region;
        this.type = type;
        this.garantie = garantie;
        this.nbre_portes = nbre_portes;
        this.Energie = Energie;
        this.nbre_cylindres = nbre_cylindres;
        this.puissance = puissance;
        this.consomation_mixte = consomation_mixte;
        this.vitesse_max = vitesse_max;
        this.performance = performance;
        this.nbre_places = nbre_places;
        this.connectivite = connectivite;
        this.Adresse = Adresse;
        this.kilometrage = kilometrage;
        this.année = année;
        this.mise_circulation = mise_circulation;
        this.num_tel = num_tel;
    }

    //les getters et les setters
    public int getId_annonces() {
        return id_annonces;
    }

    public void setId_annonces(int id_annonces) {
        this.id_annonces = id_annonces;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGarantie() {
        return garantie;
    }

    public void setGarantie(int garantie) {
        this.garantie = garantie;
    }

    public int getNbre_portes() {
        return nbre_portes;
    }

    public void setNbre_portes(int nbre_portes) {
        this.nbre_portes = nbre_portes;
    }

    public String getEnergie() {
        return Energie;
    }

    public void setEnergie(String Energie) {
        this.Energie = Energie;
    }

    public int getNbre_cylindres() {
        return nbre_cylindres;
    }

    public void setNbre_cylindres(int nbre_cylindres) {
        this.nbre_cylindres = nbre_cylindres;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public float getConsomation_mixte() {
        return consomation_mixte;
    }

    public void setConsomation_mixte(float consomation_mixte) {
        this.consomation_mixte = consomation_mixte;
    }

    public int getVitesse_max() {
        return vitesse_max;
    }

    public void setVitesse_max(int vitesse_max) {
        this.vitesse_max = vitesse_max;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    public int getNbre_places() {
        return nbre_places;
    }

    public void setNbre_places(int nbre_places) {
        this.nbre_places = nbre_places;
    }

    public boolean isConnectivite() {
        return connectivite;
    }

    public void setConnectivite(boolean connectivite) {
        this.connectivite = connectivite;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public int getAnnée() {
        return année;
    }

    public void setAnnée(int année) {
        this.année = année;
    }

    public Date getMise_circulation() {
        return mise_circulation;
    }

    public void setMise_circulation(Date mise_circulation) {
        this.mise_circulation = mise_circulation;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }
     
    
    //redefinition methode toString

    @Override
    public String toString() {
        return "Annonces{" + "id_annonces=" + id_annonces + ", titre=" + titre + ", categorie=" + categorie + ", ville=" + ville + ", description=" + description + ", prix=" + prix + ", date=" + date + ", region=" + region + ", type=" + type + ", garantie=" + garantie + ", nbre_portes=" + nbre_portes + ", Energie=" + Energie + ", nbre_cylindres=" + nbre_cylindres + ", puissance=" + puissance + ", consomation_mixte=" + consomation_mixte + ", vitesse_max=" + vitesse_max + ", performance=" + performance + ", nbre_places=" + nbre_places + ", connectivite=" + connectivite + ", Adresse=" + Adresse + ", kilometrage=" + kilometrage + ", ann\u00e9e=" + année + ", mise_circulation=" + mise_circulation + ", num_tel=" + num_tel + '}';
    }
    
    //redefinition methode equals 

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.id_annonces;
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
        final Annonces other = (Annonces) obj;
        if (this.id_annonces != other.id_annonces) {
            return false;
        }
        return true;
    }
    

   

  
    
    
}