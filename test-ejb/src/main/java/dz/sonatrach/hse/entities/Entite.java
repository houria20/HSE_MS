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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ENTITE", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Entite.findAll", query = "SELECT e FROM Entite e")
    , @NamedQuery(name = "Entite.findByIdentite", query = "SELECT e FROM Entite e WHERE e.identite = :identite")
    , @NamedQuery(name = "Entite.findByDesignationentite", query = "SELECT e FROM Entite e WHERE e.designationentite = :designationentite")
    , @NamedQuery(name = "Entite.findByNbsite", query = "SELECT e FROM Entite e WHERE e.nbsite = :nbsite")})
public class Entite implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDENTITE")
    private BigDecimal identite;
    @Size(max = 255)
    @Column(name = "DESIGNATIONENTITE")
    private String designationentite;
    @Column(name = "NBSITE")
    private BigInteger nbsite;
    @OneToMany(mappedBy = "identite")
    private List<Respentite> respentiteList;
    @OneToMany(mappedBy = "identite")
    private List<Site> siteList;
    @JoinColumn(name = "IDACT", referencedColumnName = "IDACT")
    @ManyToOne
    private Activite idact;

    public Entite() {
    }

    public Entite(BigDecimal identite) {
        this.identite = identite;
    }

    public BigDecimal getIdentite() {
        return identite;
    }

    public void setIdentite(BigDecimal identite) {
        this.identite = identite;
    }

    public String getDesignationentite() {
        return designationentite;
    }

    public void setDesignationentite(String designationentite) {
        this.designationentite = designationentite;
    }

    public BigInteger getNbsite() {
        return nbsite;
    }

    public void setNbsite(BigInteger nbsite) {
        this.nbsite = nbsite;
    }

    public List<Respentite> getRespentiteList() {
        return respentiteList;
    }

    public void setRespentiteList(List<Respentite> respentiteList) {
        this.respentiteList = respentiteList;
    }

    public List<Site> getSiteList() {
        return siteList;
    }

    public void setSiteList(List<Site> siteList) {
        this.siteList = siteList;
    }

    public Activite getIdact() {
        return idact;
    }

    public void setIdact(Activite idact) {
        this.idact = idact;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identite != null ? identite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entite)) {
            return false;
        }
        Entite other = (Entite) object;
        if ((this.identite == null && other.identite != null) || (this.identite != null && !this.identite.equals(other.identite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Entite[ identite=" + identite + " ]";
    }
    
}
