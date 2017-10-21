/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package unido.pidev.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import unido.pidev.interfaces.INotesVoitureService;

/**
 * 
 * @author Nourelhouda 
 */
public class NotesVoiture  {
    
    private int id_note ;
    private voiture voiture ;
    private String date_notes ;
    private String objet ; 
    private String details ; 
    

    public NotesVoiture() {
    }

    public NotesVoiture(int id_note, String date_notes, String objet, String details) {
        this.id_note = id_note;
        this.date_notes = date_notes;
        this.objet = objet;
        this.details = details;
    }

    public NotesVoiture(int id_note, voiture voiture, String date_notes, String objet, String details) {
        this.id_note = id_note;
        this.voiture = voiture;
        this.date_notes = date_notes;
        this.objet = objet;
        this.details = details;
    }
    
    
    public int getId_note() {
        return id_note;
    }

    public String getDate_notes() {
        return date_notes;
    }

    public String getObjet() {
        return objet;
    }

    public String getDetails() {
        return details;
    }

    public voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(voiture voiture) {
        this.voiture = voiture;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    public void setDate_notes(String date_notes) {
        this.date_notes = date_notes;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "NotesVoiture{" + "id_note=" + id_note + ", date_notes=" + date_notes + ", objet=" + objet + ", details=" + details + ", voiture=" + voiture + '}';
    }
    
    
    public java.sql.Date convert (String date) throws ParseException{
    
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date date1 = sdf1.parse(date);
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
  
        return sqlDate ;  
    }
    
    

}
