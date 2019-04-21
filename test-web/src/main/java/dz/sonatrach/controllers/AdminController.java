/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.controllers;

import dz.sonatrach.hse.entities.Vicepresident;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author pc
 */
@Named(value = "adminController")
@ManagedBean
public class AdminController {

    private String idUser;
    private String nom;
    private String prenom;
    private String email;
    private String username;
    private String pw;
    private String structure;
    Vicepresident vp= new Vicepresident();
    private final static String[] postes;

    static {
        postes = new String[6];
        postes[0] = "Vice-Président";
        postes[1] = "Reponsable Entité";
        postes[2] = "Asset Manager";
        postes[3] = "Auditeur CP";
        postes[4] = "Analyste";
        postes[5] = "Responsable Reporting";
    }

    public AdminController() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }
    
}
