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
import javax.validation.constraints.Size;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "SOUSELEMENT", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Souselement.findAll", query = "SELECT s FROM Souselement s")
    , @NamedQuery(name = "Souselement.findByIdsouselt", query = "SELECT s FROM Souselement s WHERE s.idsouselt = :idsouselt")
    , @NamedQuery(name = "Souselement.findByDesignation", query = "SELECT s FROM Souselement s WHERE s.designation = :designation")})
public class Souselement implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSOUSELT")
    private BigDecimal idsouselt;
    @Size(max = 255)
    @Column(name = "DESIGNATION")
    private String designation;
    @JoinColumn(name = "IDELT", referencedColumnName = "IDELT")
    @ManyToOne
    private Element idelt;
    @OneToMany(mappedBy = "idsouselt")
    private List<Exigence> exigenceList;

    public Souselement() {
    }

    public Souselement(BigDecimal idsouselt) {
        this.idsouselt = idsouselt;
    }

    public BigDecimal getIdsouselt() {
        return idsouselt;
    }

    public void setIdsouselt(BigDecimal idsouselt) {
        this.idsouselt = idsouselt;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Element getIdelt() {
        return idelt;
    }

    public void setIdelt(Element idelt) {
        this.idelt = idelt;
    }

    public List<Exigence> getExigenceList() {
        return exigenceList;
    }

    public void setExigenceList(List<Exigence> exigenceList) {
        this.exigenceList = exigenceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsouselt != null ? idsouselt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Souselement)) {
            return false;
        }
        Souselement other = (Souselement) object;
        if ((this.idsouselt == null && other.idsouselt != null) || (this.idsouselt != null && !this.idsouselt.equals(other.idsouselt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Souselement[ idsouselt=" + idsouselt + " ]";
    }
    
}
