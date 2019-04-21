/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.hse.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "ACTIVITE", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Activite.findAll", query = "SELECT a FROM Activite a")
    , @NamedQuery(name = "Activite.findByIdact", query = "SELECT a FROM Activite a WHERE a.idact = :idact")
    , @NamedQuery(name = "Activite.findByDesignationact", query = "SELECT a FROM Activite a WHERE a.designationact = :designationact")
    , @NamedQuery(name = "Activite.findByNbentite", query = "SELECT a FROM Activite a WHERE a.nbentite = :nbentite")})
public class Activite implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDACT")
    private BigDecimal idact;
    @Size(max = 255)
    @Column(name = "DESIGNATIONACT")
    private String designationact;
    @Column(name = "NBENTITE")
    private BigInteger nbentite;
    @OneToMany(mappedBy = "idact")
    private List<Vicepresident> vicepresidentList;
    @OneToMany(mappedBy = "idact")
    private List<Entite> entiteList;

    public Activite() {
    }

    public Activite(BigDecimal idact) {
        this.idact = idact;
    }

    public BigDecimal getIdact() {
        return idact;
    }

    public void setIdact(BigDecimal idact) {
        this.idact = idact;
    }

    public String getDesignationact() {
        return designationact;
    }

    public void setDesignationact(String designationact) {
        this.designationact = designationact;
    }

    public BigInteger getNbentite() {
        return nbentite;
    }

    public void setNbentite(BigInteger nbentite) {
        this.nbentite = nbentite;
    }

    public List<Vicepresident> getVicepresidentList() {
        return vicepresidentList;
    }

    public void setVicepresidentList(List<Vicepresident> vicepresidentList) {
        this.vicepresidentList = vicepresidentList;
    }

    public List<Entite> getEntiteList() {
        return entiteList;
    }

    public void setEntiteList(List<Entite> entiteList) {
        this.entiteList = entiteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idact != null ? idact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activite)) {
            return false;
        }
        Activite other = (Activite) object;
        if ((this.idact == null && other.idact != null) || (this.idact != null && !this.idact.equals(other.idact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Activite[ idact=" + idact + " ]";
    }
    
}
