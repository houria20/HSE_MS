/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.hse.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "RESULTATEXIGENCE", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Resultatexigence.findAll", query = "SELECT r FROM Resultatexigence r")
    , @NamedQuery(name = "Resultatexigence.findByIdresultatexigence", query = "SELECT r FROM Resultatexigence r WHERE r.idresultatexigence = :idresultatexigence")
    , @NamedQuery(name = "Resultatexigence.findByReponse", query = "SELECT r FROM Resultatexigence r WHERE r.reponse = :reponse")
    , @NamedQuery(name = "Resultatexigence.findByScoreopactuel", query = "SELECT r FROM Resultatexigence r WHERE r.scoreopactuel = :scoreopactuel")
    , @NamedQuery(name = "Resultatexigence.findByScoreopprojete", query = "SELECT r FROM Resultatexigence r WHERE r.scoreopprojete = :scoreopprojete")
    , @NamedQuery(name = "Resultatexigence.findByScoreorgactuel", query = "SELECT r FROM Resultatexigence r WHERE r.scoreorgactuel = :scoreorgactuel")
    , @NamedQuery(name = "Resultatexigence.findByScoreorgprojete", query = "SELECT r FROM Resultatexigence r WHERE r.scoreorgprojete = :scoreorgprojete")
    , @NamedQuery(name = "Resultatexigence.findByTypologieconstatactuel", query = "SELECT r FROM Resultatexigence r WHERE r.typologieconstatactuel = :typologieconstatactuel")
    , @NamedQuery(name = "Resultatexigence.findByTypologieconstatprojete", query = "SELECT r FROM Resultatexigence r WHERE r.typologieconstatprojete = :typologieconstatprojete")})
public class Resultatexigence implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDRESULTATEXIGENCE")
    private BigDecimal idresultatexigence;
    @Size(max = 255)
    @Column(name = "REPONSE")
    private String reponse;
    @Column(name = "SCOREOPACTUEL")
    private BigDecimal scoreopactuel;
    @Column(name = "SCOREOPPROJETE")
    private BigDecimal scoreopprojete;
    @Column(name = "SCOREORGACTUEL")
    private BigDecimal scoreorgactuel;
    @Column(name = "SCOREORGPROJETE")
    private BigDecimal scoreorgprojete;
    @Size(max = 255)
    @Column(name = "TYPOLOGIECONSTATACTUEL")
    private String typologieconstatactuel;
    @Size(max = 255)
    @Column(name = "TYPOLOGIECONSTATPROJETE")
    private String typologieconstatprojete;

    public Resultatexigence() {
    }

    public Resultatexigence(BigDecimal idresultatexigence) {
        this.idresultatexigence = idresultatexigence;
    }

    public BigDecimal getIdresultatexigence() {
        return idresultatexigence;
    }

    public void setIdresultatexigence(BigDecimal idresultatexigence) {
        this.idresultatexigence = idresultatexigence;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public BigDecimal getScoreopactuel() {
        return scoreopactuel;
    }

    public void setScoreopactuel(BigDecimal scoreopactuel) {
        this.scoreopactuel = scoreopactuel;
    }

    public BigDecimal getScoreopprojete() {
        return scoreopprojete;
    }

    public void setScoreopprojete(BigDecimal scoreopprojete) {
        this.scoreopprojete = scoreopprojete;
    }

    public BigDecimal getScoreorgactuel() {
        return scoreorgactuel;
    }

    public void setScoreorgactuel(BigDecimal scoreorgactuel) {
        this.scoreorgactuel = scoreorgactuel;
    }

    public BigDecimal getScoreorgprojete() {
        return scoreorgprojete;
    }

    public void setScoreorgprojete(BigDecimal scoreorgprojete) {
        this.scoreorgprojete = scoreorgprojete;
    }

    public String getTypologieconstatactuel() {
        return typologieconstatactuel;
    }

    public void setTypologieconstatactuel(String typologieconstatactuel) {
        this.typologieconstatactuel = typologieconstatactuel;
    }

    public String getTypologieconstatprojete() {
        return typologieconstatprojete;
    }

    public void setTypologieconstatprojete(String typologieconstatprojete) {
        this.typologieconstatprojete = typologieconstatprojete;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresultatexigence != null ? idresultatexigence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultatexigence)) {
            return false;
        }
        Resultatexigence other = (Resultatexigence) object;
        if ((this.idresultatexigence == null && other.idresultatexigence != null) || (this.idresultatexigence != null && !this.idresultatexigence.equals(other.idresultatexigence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Resultatexigence[ idresultatexigence=" + idresultatexigence + " ]";
    }
    
}
