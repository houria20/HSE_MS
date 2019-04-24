/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.controllers;

import dz.sonatrach.hse.sessionbeans.*;
import dz.sonatrach.hse.entities.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author pc
 */
@Named(value = "adminController")
@ManagedBean
@SessionScoped
public class AdminController {

    private String idUser = "aaa";
    private String nom = "aaa";
    private String prenom = "aaa";
    private String email = "aaa@gmail.com";
    private String username = "aaa";
    private String pw = "aaa";
    private String structure = "aaa";
    private String entite = "";
    private String site = "";
    private int idEquipe;
    Utilisateur user = new Utilisateur();
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
    @EJB(beanName = "UtilisateurFacade")
    UtilisateurFacade userFacade = new UtilisateurFacade();

    private List<Utilisateur> filteredAccounts;
    private boolean presidentCP;

    public AdminController() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public boolean isPresidentCP() {
        return presidentCP;
    }

    public void setPresidentCP(boolean presidentCP) {
        this.presidentCP = presidentCP;
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

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public String getEntite() {
        return entite;
    }

    public void setEntite(String entite) {
        this.entite = entite;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public List<String> getPostes() {
        return Arrays.asList(postes);
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public List<Utilisateur> getAllUsers() {
        if (userFacade.findAll() == null) {
            return new ArrayList(2);
        }
        return userFacade.findAll();
    }

    public List<Utilisateur> getFilteredAccounts() {
        return filteredAccounts;
    }

    public void setFilteredAccounts(List<Utilisateur> filteredAccounts) {
        this.filteredAccounts = filteredAccounts;
    }

    public void destroyWorld() {
        System.out.println("dz.sonatrach.controllers.AdminController.destroyWorld()");
    }

    public String deleteAction(Utilisateur admin) {
        return "";
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modification effectuée", ((Utilisateur) event.getObject()).getIduser());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modification annulée", ((Utilisateur) event.getObject()).getIduser());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Champ modifié", "Ancienne valeur: " + oldValue + ", Nouvelle valeur:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void emptyVariables() {
        this.idUser = "";
        this.nom = "";
        this.prenom = "";
        this.username = "";
        this.pw = "";
        this.email = "";
    }

    public void createUser() {
        System.out.println("debut de la methode");
        System.out.println("apres instanciation de user");
        System.out.println(this.idUser);
        this.user.setIduser(this.idUser);
        this.user.setNom(this.nom);
        this.user.setPrenom(this.prenom);
        this.user.setEmail(this.email);
        this.user.setUsername("son" + this.username.toLowerCase());
        this.user.setPassword(this.pw);
        System.out.println("avant la bd");
        userFacade.create(user);
        this.emptyVariables();
       System.out.println("fin de la methode");
    }
}
