package dz.sonatrach.controllers;

import dz.sonatrach.hse.entities.*;
import dz.sonatrach.hse.sessionbeans.*;
import dz.sonatrach.util.SessionUser;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class LoginForm {

    @EJB(beanName = "UtilisateurFacade")
    private UtilisateurFacade utilisateurFacade = new UtilisateurFacade();

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
    

    public boolean validate() {
       
        Utilisateur user = utilisateurFacade.find(this.username);
        
        if (user != null) {
           
            return this.password.equals(user.getPassword());
        } else {
            return false;
        }
    }

    public String login() {
        if (this.validate()) {
            HttpSession session = SessionUser.getSession();
            return "adminUI";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Passowrd", "Please enter correct username and Password"));
            return "index";
        }
    }
    //logout event, invalidate session

    public String logout() {
        HttpSession session = SessionUser.getSession();
        session.invalidate();
        return "index";
    }
}
