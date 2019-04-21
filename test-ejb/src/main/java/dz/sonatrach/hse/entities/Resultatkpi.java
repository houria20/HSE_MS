/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.hse.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "RESULTATKPI", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Resultatkpi.findAll", query = "SELECT r FROM Resultatkpi r")
    , @NamedQuery(name = "Resultatkpi.findByIdresultat", query = "SELECT r FROM Resultatkpi r WHERE r.idresultat = :idresultat")
    , @NamedQuery(name = "Resultatkpi.findByAnnee", query = "SELECT r FROM Resultatkpi r WHERE r.annee = :annee")
    , @NamedQuery(name = "Resultatkpi.findByIdkpi", query = "SELECT r FROM Resultatkpi r WHERE r.idkpi = :idkpi")
    , @NamedQuery(name = "Resultatkpi.findByObjectif", query = "SELECT r FROM Resultatkpi r WHERE r.objectif = :objectif")
    , @NamedQuery(name = "Resultatkpi.findByValeur", query = "SELECT r FROM Resultatkpi r WHERE r.valeur = :valeur")})
public class Resultatkpi implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESULTAT")
    private BigDecimal idresultat;
    @Column(name = "ANNEE")
    private BigInteger annee;
    @Column(name = "IDKPI")
    private BigInteger idkpi;
    @Column(name = "OBJECTIF")
    private BigDecimal objectif;
    @Column(name = "VALEUR")
    private BigDecimal valeur;

    public Resultatkpi() {
    }

    public Resultatkpi(BigDecimal idresultat) {
        this.idresultat = idresultat;
    }

    public BigDecimal getIdresultat() {
        return idresultat;
    }

    public void setIdresultat(BigDecimal idresultat) {
        this.idresultat = idresultat;
    }

    public BigInteger getAnnee() {
        return annee;
    }

    public void setAnnee(BigInteger annee) {
        this.annee = annee;
    }

    public BigInteger getIdkpi() {
        return idkpi;
    }

    public void setIdkpi(BigInteger idkpi) {
        this.idkpi = idkpi;
    }

    public BigDecimal getObjectif() {
        return objectif;
    }

    public void setObjectif(BigDecimal objectif) {
        this.objectif = objectif;
    }

    public BigDecimal getValeur() {
        return valeur;
    }

    public void setValeur(BigDecimal valeur) {
        this.valeur = valeur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresultat != null ? idresultat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultatkpi)) {
            return false;
        }
        Resultatkpi other = (Resultatkpi) object;
        if ((this.idresultat == null && other.idresultat != null) || (this.idresultat != null && !this.idresultat.equals(other.idresultat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Resultatkpi[ idresultat=" + idresultat + " ]";
    }
    
}
