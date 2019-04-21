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
@Table(name = "RESULTATELT", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Resultatelt.findAll", query = "SELECT r FROM Resultatelt r")
    , @NamedQuery(name = "Resultatelt.findByIdresultatelt", query = "SELECT r FROM Resultatelt r WHERE r.idresultatelt = :idresultatelt")
    , @NamedQuery(name = "Resultatelt.findByIdelt", query = "SELECT r FROM Resultatelt r WHERE r.idelt = :idelt")
    , @NamedQuery(name = "Resultatelt.findByIdgrilleaudit", query = "SELECT r FROM Resultatelt r WHERE r.idgrilleaudit = :idgrilleaudit")
    , @NamedQuery(name = "Resultatelt.findByMoyopactuel", query = "SELECT r FROM Resultatelt r WHERE r.moyopactuel = :moyopactuel")
    , @NamedQuery(name = "Resultatelt.findByMoyopprojete", query = "SELECT r FROM Resultatelt r WHERE r.moyopprojete = :moyopprojete")
    , @NamedQuery(name = "Resultatelt.findByMoyorgactuel", query = "SELECT r FROM Resultatelt r WHERE r.moyorgactuel = :moyorgactuel")
    , @NamedQuery(name = "Resultatelt.findByMoyorgprojete", query = "SELECT r FROM Resultatelt r WHERE r.moyorgprojete = :moyorgprojete")})
public class Resultatelt implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESULTATELT")
    private BigDecimal idresultatelt;
    @Column(name = "IDELT")
    private BigInteger idelt;
    @Column(name = "IDGRILLEAUDIT")
    private BigInteger idgrilleaudit;
    @Column(name = "MOYOPACTUEL")
    private BigDecimal moyopactuel;
    @Column(name = "MOYOPPROJETE")
    private BigDecimal moyopprojete;
    @Column(name = "MOYORGACTUEL")
    private BigDecimal moyorgactuel;
    @Column(name = "MOYORGPROJETE")
    private BigDecimal moyorgprojete;

    public Resultatelt() {
    }

    public Resultatelt(BigDecimal idresultatelt) {
        this.idresultatelt = idresultatelt;
    }

    public BigDecimal getIdresultatelt() {
        return idresultatelt;
    }

    public void setIdresultatelt(BigDecimal idresultatelt) {
        this.idresultatelt = idresultatelt;
    }

    public BigInteger getIdelt() {
        return idelt;
    }

    public void setIdelt(BigInteger idelt) {
        this.idelt = idelt;
    }

    public BigInteger getIdgrilleaudit() {
        return idgrilleaudit;
    }

    public void setIdgrilleaudit(BigInteger idgrilleaudit) {
        this.idgrilleaudit = idgrilleaudit;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresultatelt != null ? idresultatelt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultatelt)) {
            return false;
        }
        Resultatelt other = (Resultatelt) object;
        if ((this.idresultatelt == null && other.idresultatelt != null) || (this.idresultatelt != null && !this.idresultatelt.equals(other.idresultatelt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Resultatelt[ idresultatelt=" + idresultatelt + " ]";
    }
    
}
