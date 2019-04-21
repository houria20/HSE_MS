/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.hse.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "PLANDACTION", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Plandaction.findAll", query = "SELECT p FROM Plandaction p")
    , @NamedQuery(name = "Plandaction.findByIdplan", query = "SELECT p FROM Plandaction p WHERE p.idplan = :idplan")
    , @NamedQuery(name = "Plandaction.findByDateelaboration", query = "SELECT p FROM Plandaction p WHERE p.dateelaboration = :dateelaboration")})
public class Plandaction implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPLAN")
    private BigDecimal idplan;
    @Column(name = "DATEELABORATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateelaboration;
    @JoinColumn(name = "ANALYSTE_IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne
    private Utilisateur analysteIduser;
    @OneToMany(mappedBy = "idplan")
    private List<Action> actionList;

    public Plandaction() {
    }

    public Plandaction(BigDecimal idplan) {
        this.idplan = idplan;
    }

    public BigDecimal getIdplan() {
        return idplan;
    }

    public void setIdplan(BigDecimal idplan) {
        this.idplan = idplan;
    }

    public Date getDateelaboration() {
        return dateelaboration;
    }

    public void setDateelaboration(Date dateelaboration) {
        this.dateelaboration = dateelaboration;
    }

    public Utilisateur getAnalysteIduser() {
        return analysteIduser;
    }

    public void setAnalysteIduser(Utilisateur analysteIduser) {
        this.analysteIduser = analysteIduser;
    }

    public List<Action> getActionList() {
        return actionList;
    }

    public void setActionList(List<Action> actionList) {
        this.actionList = actionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplan != null ? idplan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plandaction)) {
            return false;
        }
        Plandaction other = (Plandaction) object;
        if ((this.idplan == null && other.idplan != null) || (this.idplan != null && !this.idplan.equals(other.idplan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Plandaction[ idplan=" + idplan + " ]";
    }
    
}
