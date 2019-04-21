/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.hse.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author pc
 */
@Entity
@Table(name = "TABLEAUDEBORD", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Tableaudebord.findAll", query = "SELECT t FROM Tableaudebord t")
    , @NamedQuery(name = "Tableaudebord.findByIdtb", query = "SELECT t FROM Tableaudebord t WHERE t.idtb = :idtb")})
public class Tableaudebord implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTB")
    private BigDecimal idtb;
    @JoinColumn(name = "RR_IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne
    private Utilisateur rrIduser;
    @OneToMany(mappedBy = "idtb")
    private List<Kpi> kpiList;

    public Tableaudebord() {
    }

    public Tableaudebord(BigDecimal idtb) {
        this.idtb = idtb;
    }

    public BigDecimal getIdtb() {
        return idtb;
    }

    public void setIdtb(BigDecimal idtb) {
        this.idtb = idtb;
    }

    public Utilisateur getRrIduser() {
        return rrIduser;
    }

    public void setRrIduser(Utilisateur rrIduser) {
        this.rrIduser = rrIduser;
    }

    public List<Kpi> getKpiList() {
        return kpiList;
    }

    public void setKpiList(List<Kpi> kpiList) {
        this.kpiList = kpiList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtb != null ? idtb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tableaudebord)) {
            return false;
        }
        Tableaudebord other = (Tableaudebord) object;
        if ((this.idtb == null && other.idtb != null) || (this.idtb != null && !this.idtb.equals(other.idtb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Tableaudebord[ idtb=" + idtb + " ]";
    }
    
}
