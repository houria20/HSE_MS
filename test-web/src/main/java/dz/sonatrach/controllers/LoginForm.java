package dz.sonatrach.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class LoginForm {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {
        System.out.println("debut login");
        FacesMessage msg = null;
     
        if (this.username != null && this.username.equals("admin") && this.password.equals("admin")) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenue", username);
        } else {
                       msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur de connexion", "Informations d'identification non valides");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
         System.out.println("fin login");
    }
}
