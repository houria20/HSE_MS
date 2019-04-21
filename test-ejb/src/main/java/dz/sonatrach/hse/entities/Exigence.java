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
@Table(name = "EXIGENCE", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Exigence.findAll", query = "SELECT e FROM Exigence e")
    , @NamedQuery(name = "Exigence.findByIdexigence", query = "SELECT e FROM Exigence e WHERE e.idexigence = :idexigence")
    , @NamedQuery(name = "Exigence.findByGuidedenotation", query = "SELECT e FROM Exigence e WHERE e.guidedenotation = :guidedenotation")
    , @NamedQuery(name = "Exigence.findByPointdecontrole", query = "SELECT e FROM Exigence e WHERE e.pointdecontrole = :pointdecontrole")
    , @NamedQuery(name = "Exigence.findByQst", query = "SELECT e FROM Exigence e WHERE e.qst = :qst")})
public class Exigence implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEXIGENCE")
    private BigDecimal idexigence;
    @Size(max = 255)
    @Column(name = "GUIDEDENOTATION")
    private String guidedenotation;
    @Size(max = 255)
    @Column(name = "POINTDECONTROLE")
    private String pointdecontrole;
    @Size(max = 255)
    @Column(name = "QST")
    private String qst;
    @JoinColumn(name = "IDSOUSELT", referencedColumnName = "IDSOUSELT")
    @ManyToOne
    private Souselement idsouselt;

    public Exigence() {
    }

    public Exigence(BigDecimal idexigence) {
        this.idexigence = idexigence;
    }

    public BigDecimal getIdexigence() {
        return idexigence;
    }

    public void setIdexigence(BigDecimal idexigence) {
        this.idexigence = idexigence;
    }

    public String getGuidedenotation() {
        return guidedenotation;
    }

    public void setGuidedenotation(String guidedenotation) {
        this.guidedenotation = guidedenotation;
    }

    public String getPointdecontrole() {
        return pointdecontrole;
    }

    public void setPointdecontrole(String pointdecontrole) {
        this.pointdecontrole = pointdecontrole;
    }

    public String getQst() {
        return qst;
    }

    public void setQst(String qst) {
        this.qst = qst;
    }

    public Souselement getIdsouselt() {
        return idsouselt;
    }

    public void setIdsouselt(Souselement idsouselt) {
        this.idsouselt = idsouselt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexigence != null ? idexigence.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exigence)) {
            return false;
        }
        Exigence other = (Exigence) object;
        if ((this.idexigence == null && other.idexigence != null) || (this.idexigence != null && !this.idexigence.equals(other.idexigence))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Exigence[ idexigence=" + idexigence + " ]";
    }
    
}
