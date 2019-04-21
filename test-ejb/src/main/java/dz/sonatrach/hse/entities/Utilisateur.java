/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.hse.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "UTILISATEUR", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByIduser", query = "SELECT u FROM Utilisateur u WHERE u.iduser = :iduser")
    , @NamedQuery(name = "Utilisateur.findByDtype", query = "SELECT u FROM Utilisateur u WHERE u.dtype = :dtype")
    , @NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email")
    , @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom")
    , @NamedQuery(name = "Utilisateur.findByPassword", query = "SELECT u FROM Utilisateur u WHERE u.password = :password")
    , @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom")
    , @NamedQuery(name = "Utilisateur.findByUsername", query = "SELECT u FROM Utilisateur u WHERE u.username = :username")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "IDUSER")
    private String iduser;
    @Size(max = 31)
    @Column(name = "DTYPE")
    private String dtype;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 255)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 255)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 255)
    @Column(name = "USERNAME")
    private String username;
    @OneToMany(mappedBy = "idmembre")
    private List<Affectation> affectationList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Vicepresident vicepresident;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Respentite respentite;
    @OneToMany(mappedBy = "rrIduser")
    private List<Tableaudebord> tableaudebordList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Assetmanager assetmanager;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Respreporting respreporting;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Directeurcentral directeurcentral;
    @OneToMany(mappedBy = "respauditIduser")
    private List<Equipeaudit> equipeauditList;
    @OneToMany(mappedBy = "analysteIduser")
    private List<Plandaction> plandactionList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Membreaudit membreaudit;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Respaudit respaudit;
    @OneToMany(mappedBy = "respauditIduser")
    private List<Grilleaudit> grilleauditList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "utilisateur")
    private Analyste analyste;

    public Utilisateur() {
    }

    public Utilisateur(String iduser) {
        this.iduser = iduser;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Affectation> getAffectationList() {
        return affectationList;
    }

    public void setAffectationList(List<Affectation> affectationList) {
        this.affectationList = affectationList;
    }

    public Vicepresident getVicepresident() {
        return vicepresident;
    }

    public void setVicepresident(Vicepresident vicepresident) {
        this.vicepresident = vicepresident;
    }

    public Respentite getRespentite() {
        return respentite;
    }

    public void setRespentite(Respentite respentite) {
        this.respentite = respentite;
    }

    public List<Tableaudebord> getTableaudebordList() {
        return tableaudebordList;
    }

    public void setTableaudebordList(List<Tableaudebord> tableaudebordList) {
        this.tableaudebordList = tableaudebordList;
    }

    public Assetmanager getAssetmanager() {
        return assetmanager;
    }

    public void setAssetmanager(Assetmanager assetmanager) {
        this.assetmanager = assetmanager;
    }

    public Respreporting getRespreporting() {
        return respreporting;
    }

    public void setRespreporting(Respreporting respreporting) {
        this.respreporting = respreporting;
    }

    public Directeurcentral getDirecteurcentral() {
        return directeurcentral;
    }

    public void setDirecteurcentral(Directeurcentral directeurcentral) {
        this.directeurcentral = directeurcentral;
    }

    public List<Equipeaudit> getEquipeauditList() {
        return equipeauditList;
    }

    public void setEquipeauditList(List<Equipeaudit> equipeauditList) {
        this.equipeauditList = equipeauditList;
    }

    public List<Plandaction> getPlandactionList() {
        return plandactionList;
    }

    public void setPlandactionList(List<Plandaction> plandactionList) {
        this.plandactionList = plandactionList;
    }

    public Membreaudit getMembreaudit() {
        return membreaudit;
    }

    public void setMembreaudit(Membreaudit membreaudit) {
        this.membreaudit = membreaudit;
    }

    public Respaudit getRespaudit() {
        return respaudit;
    }

    public void setRespaudit(Respaudit respaudit) {
        this.respaudit = respaudit;
    }

    public List<Grilleaudit> getGrilleauditList() {
        return grilleauditList;
    }

    public void setGrilleauditList(List<Grilleaudit> grilleauditList) {
        this.grilleauditList = grilleauditList;
    }

    public Analyste getAnalyste() {
        return analyste;
    }

    public void setAnalyste(Analyste analyste) {
        this.analyste = analyste;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Utilisateur[ iduser=" + iduser + " ]";
    }
    
}
