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
@Table(name = "KPI", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Kpi.findAll", query = "SELECT k FROM Kpi k")
    , @NamedQuery(name = "Kpi.findByIdkpi", query = "SELECT k FROM Kpi k WHERE k.idkpi = :idkpi")
    , @NamedQuery(name = "Kpi.findByDesignationkpi", query = "SELECT k FROM Kpi k WHERE k.designationkpi = :designationkpi")
    , @NamedQuery(name = "Kpi.findByTypekpi", query = "SELECT k FROM Kpi k WHERE k.typekpi = :typekpi")})
public class Kpi implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDKPI")
    private BigDecimal idkpi;
    @Size(max = 255)
    @Column(name = "DESIGNATIONKPI")
    private String designationkpi;
    @Size(max = 255)
    @Column(name = "TYPEKPI")
    private String typekpi;
    @JoinColumn(name = "IDTB", referencedColumnName = "IDTB")
    @ManyToOne
    private Tableaudebord idtb;

    public Kpi() {
    }

    public Kpi(BigDecimal idkpi) {
        this.idkpi = idkpi;
    }

    public BigDecimal getIdkpi() {
        return idkpi;
    }

    public void setIdkpi(BigDecimal idkpi) {
        this.idkpi = idkpi;
    }

    public String getDesignationkpi() {
        return designationkpi;
    }

    public void setDesignationkpi(String designationkpi) {
        this.designationkpi = designationkpi;
    }

    public String getTypekpi() {
        return typekpi;
    }

    public void setTypekpi(String typekpi) {
        this.typekpi = typekpi;
    }

    public Tableaudebord getIdtb() {
        return idtb;
    }

    public void setIdtb(Tableaudebord idtb) {
        this.idtb = idtb;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idkpi != null ? idkpi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kpi)) {
            return false;
        }
        Kpi other = (Kpi) object;
        if ((this.idkpi == null && other.idkpi != null) || (this.idkpi != null && !this.idkpi.equals(other.idkpi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Kpi[ idkpi=" + idkpi + " ]";
    }
    
}
