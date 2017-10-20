/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unido.pidev.models;

import java.util.Objects;

/**
 *
 * @author MALEK
 */
public class Test_autoecole {
    private int id_test;
    private String question;
    private String reponses;
    private User user;

    public Test_autoecole() {
    }

    public Test_autoecole(int id_test, String question, String reponses, User user) {
        this.id_test = id_test;
        this.question = question;
        this.reponses = reponses;
        this.user = user;
    }

    public int getId_test() {
        return id_test;
    }

    public void setId_test(int id_test) {
        this.id_test = id_test;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponses() {
        return reponses;
    }

    public void setReponses(String reponses) {
        this.reponses = reponses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Test_autoecole{" + "id_test=" + id_test + ", question=" + question + ", reponses=" + reponses + ", user=" + user + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Test_autoecole other = (Test_autoecole) obj;
        if (!Objects.equals(this.id_test, other.id_test)) {
            return false;
        }
        return true;
    }
    
    
}
