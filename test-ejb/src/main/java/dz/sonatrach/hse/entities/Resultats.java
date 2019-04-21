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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "RESULTATS", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Resultats.findAll", query = "SELECT r FROM Resultats r")
    , @NamedQuery(name = "Resultats.findById", query = "SELECT r FROM Resultats r WHERE r.id = :id")
    , @NamedQuery(name = "Resultats.findByIdr", query = "SELECT r FROM Resultats r WHERE r.idr = :idr")
    , @NamedQuery(name = "Resultats.findByIdresultat", query = "SELECT r FROM Resultats r WHERE r.idresultat = :idresultat")
    , @NamedQuery(name = "Resultats.findByTyper", query = "SELECT r FROM Resultats r WHERE r.typer = :typer")})
public class Resultats implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "IDR")
    private BigInteger idr;
    @Column(name = "IDRESULTAT")
    private BigInteger idresultat;
    @Size(max = 255)
    @Column(name = "TYPER")
    private String typer;
    @JoinColumn(name = "IDAUDIT", referencedColumnName = "IDAUDIT")
    @ManyToOne
    private Listeaudit idaudit;

    public Resultats() {
    }

    public Resultats(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getIdr() {
        return idr;
    }

    public void setIdr(BigInteger idr) {
        this.idr = idr;
    }

    public BigInteger getIdresultat() {
        return idresultat;
    }

    public void setIdresultat(BigInteger idresultat) {
        this.idresultat = idresultat;
    }

    public String getTyper() {
        return typer;
    }

    public void setTyper(String typer) {
        this.typer = typer;
    }

    public Listeaudit getIdaudit() {
        return idaudit;
    }

    public void setIdaudit(Listeaudit idaudit) {
        this.idaudit = idaudit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultats)) {
            return false;
        }
        Resultats other = (Resultats) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Resultats[ id=" + id + " ]";
    }
    
}
