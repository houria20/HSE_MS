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
@Table(name = "SITE", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s")
    , @NamedQuery(name = "Site.findByIdsite", query = "SELECT s FROM Site s WHERE s.idsite = :idsite")
    , @NamedQuery(name = "Site.findByDesignationsite", query = "SELECT s FROM Site s WHERE s.designationsite = :designationsite")
    , @NamedQuery(name = "Site.findByEffectif", query = "SELECT s FROM Site s WHERE s.effectif = :effectif")})
public class Site implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSITE")
    private BigDecimal idsite;
    @Size(max = 255)
    @Column(name = "DESIGNATIONSITE")
    private String designationsite;
    @Column(name = "EFFECTIF")
    private BigInteger effectif;
    @OneToMany(mappedBy = "idsite")
    private List<Assetmanager> assetmanagerList;
    @JoinColumn(name = "IDENTITE", referencedColumnName = "IDENTITE")
    @ManyToOne
    private Entite identite;
    @OneToMany(mappedBy = "idsite")
    private List<Listeaudit> listeauditList;

    public Site() {
    }

    public Site(BigDecimal idsite) {
        this.idsite = idsite;
    }

    public BigDecimal getIdsite() {
        return idsite;
    }

    public void setIdsite(BigDecimal idsite) {
        this.idsite = idsite;
    }

    public String getDesignationsite() {
        return designationsite;
    }

    public void setDesignationsite(String designationsite) {
        this.designationsite = designationsite;
    }

    public BigInteger getEffectif() {
        return effectif;
    }

    public void setEffectif(BigInteger effectif) {
        this.effectif = effectif;
    }

    public List<Assetmanager> getAssetmanagerList() {
        return assetmanagerList;
    }

    public void setAssetmanagerList(List<Assetmanager> assetmanagerList) {
        this.assetmanagerList = assetmanagerList;
    }

    public Entite getIdentite() {
        return identite;
    }

    public void setIdentite(Entite identite) {
        this.identite = identite;
    }

    public List<Listeaudit> getListeauditList() {
        return listeauditList;
    }

    public void setListeauditList(List<Listeaudit> listeauditList) {
        this.listeauditList = listeauditList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsite != null ? idsite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Site)) {
            return false;
        }
        Site other = (Site) object;
        if ((this.idsite == null && other.idsite != null) || (this.idsite != null && !this.idsite.equals(other.idsite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Site[ idsite=" + idsite + " ]";
    }
    
}
