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
@Table(name = "RESULTATSOUSELT", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Resultatsouselt.findAll", query = "SELECT r FROM Resultatsouselt r")
    , @NamedQuery(name = "Resultatsouselt.findByIdresultatsouselt", query = "SELECT r FROM Resultatsouselt r WHERE r.idresultatsouselt = :idresultatsouselt")
    , @NamedQuery(name = "Resultatsouselt.findByIdsouselt", query = "SELECT r FROM Resultatsouselt r WHERE r.idsouselt = :idsouselt")
    , @NamedQuery(name = "Resultatsouselt.findByMoyopactuel", query = "SELECT r FROM Resultatsouselt r WHERE r.moyopactuel = :moyopactuel")
    , @NamedQuery(name = "Resultatsouselt.findByMoyopprojete", query = "SELECT r FROM Resultatsouselt r WHERE r.moyopprojete = :moyopprojete")
    , @NamedQuery(name = "Resultatsouselt.findByMoyorgactuel", query = "SELECT r FROM Resultatsouselt r WHERE r.moyorgactuel = :moyorgactuel")
    , @NamedQuery(name = "Resultatsouselt.findByMoyorgprojete", query = "SELECT r FROM Resultatsouselt r WHERE r.moyorgprojete = :moyorgprojete")
    , @NamedQuery(name = "Resultatsouselt.findByNburgences", query = "SELECT r FROM Resultatsouselt r WHERE r.nburgences = :nburgences")})
public class Resultatsouselt implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESULTATSOUSELT")
    private BigDecimal idresultatsouselt;
    @Column(name = "IDSOUSELT")
    private BigInteger idsouselt;
    @Column(name = "MOYOPACTUEL")
    private BigDecimal moyopactuel;
    @Column(name = "MOYOPPROJETE")
    private BigDecimal moyopprojete;
    @Column(name = "MOYORGACTUEL")
    private BigDecimal moyorgactuel;
    @Column(name = "MOYORGPROJETE")
    private BigDecimal moyorgprojete;
    @Column(name = "NBURGENCES")
    private BigInteger nburgences;

    public Resultatsouselt() {
    }

    public Resultatsouselt(BigDecimal idresultatsouselt) {
        this.idresultatsouselt = idresultatsouselt;
    }

    public BigDecimal getIdresultatsouselt() {
        return idresultatsouselt;
    }

    public void setIdresultatsouselt(BigDecimal idresultatsouselt) {
        this.idresultatsouselt = idresultatsouselt;
    }

    public BigInteger getIdsouselt() {
        return idsouselt;
    }

    public void setIdsouselt(BigInteger idsouselt) {
        this.idsouselt = idsouselt;
    }

    public BigDecimal getMoyopactuel() {
        return moyopactuel;
    }

    public void setMoyopactuel(BigDecimal moyopactuel) {
        this.moyopactuel = moyopactuel;
    }

    public BigDecimal getMoyopprojete() {
        return moyopprojete;
    }

    public void setMoyopprojete(BigDecimal moyopprojete) {
        this.moyopprojete = moyopprojete;
    }

    public BigDecimal getMoyorgactuel() {
        return moyorgactuel;
    }

    public void setMoyorgactuel(BigDecimal moyorgactuel) {
        this.moyorgactuel = moyorgactuel;
    }

    public BigDecimal getMoyorgprojete() {
        return moyorgprojete;
    }

    public void setMoyorgprojete(BigDecimal moyorgprojete) {
        this.moyorgprojete = moyorgprojete;
    }

    public BigInteger getNburgences() {
        return nburgences;
    }

    public void setNburgences(BigInteger nburgences) {
        this.nburgences = nburgences;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresultatsouselt != null ? idresultatsouselt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultatsouselt)) {
            return false;
        }
        Resultatsouselt other = (Resultatsouselt) object;
        if ((this.idresultatsouselt == null && other.idresultatsouselt != null) || (this.idresultatsouselt != null && !this.idresultatsouselt.equals(other.idresultatsouselt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Resultatsouselt[ idresultatsouselt=" + idresultatsouselt + " ]";
    }
    
}
