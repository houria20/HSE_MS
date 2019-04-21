/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.hse.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "MEMBREAUDIT", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Membreaudit.findAll", query = "SELECT m FROM Membreaudit m")
    , @NamedQuery(name = "Membreaudit.findByIduser", query = "SELECT m FROM Membreaudit m WHERE m.iduser = :iduser")
    , @NamedQuery(name = "Membreaudit.findBySpecialite", query = "SELECT m FROM Membreaudit m WHERE m.specialite = :specialite")})
public class Membreaudit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "IDUSER")
    private String iduser;
    @Size(max = 255)
    @Column(name = "SPECIALITE")
    private String specialite;
    @JoinColumn(name = "IDEQUIPE", referencedColumnName = "IDEQUIPE")
    @ManyToOne
    private Equipeaudit idequipe;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Utilisateur utilisateur;

    public Membreaudit() {
    }

    public Membreaudit(String iduser) {
        this.iduser = iduser;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Equipeaudit getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(Equipeaudit idequipe) {
        this.idequipe = idequipe;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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
        if (!(object instanceof Membreaudit)) {
            return false;
        }
        Membreaudit other = (Membreaudit) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Membreaudit[ iduser=" + iduser + " ]";
    }
    
}
