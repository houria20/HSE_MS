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
@Table(name = "ASSETMANAGER", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Assetmanager.findAll", query = "SELECT a FROM Assetmanager a")
    , @NamedQuery(name = "Assetmanager.findByIduser", query = "SELECT a FROM Assetmanager a WHERE a.iduser = :iduser")})
public class Assetmanager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "IDUSER")
    private String iduser;
    @JoinColumn(name = "IDSITE", referencedColumnName = "IDSITE")
    @ManyToOne
    private Site idsite;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Utilisateur utilisateur;

    public Assetmanager() {
    }

    public Assetmanager(String iduser) {
        this.iduser = iduser;
    }

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public Site getIdsite() {
        return idsite;
    }

    public void setIdsite(Site idsite) {
        this.idsite = idsite;
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
        if (!(object instanceof Assetmanager)) {
            return false;
        }
        Assetmanager other = (Assetmanager) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Assetmanager[ iduser=" + iduser + " ]";
    }
    
}
