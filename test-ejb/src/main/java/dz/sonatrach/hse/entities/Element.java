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
@Table(name = "ELEMENT", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Element.findAll", query = "SELECT e FROM Element e")
    , @NamedQuery(name = "Element.findByIdelt", query = "SELECT e FROM Element e WHERE e.idelt = :idelt")
    , @NamedQuery(name = "Element.findByDesignation", query = "SELECT e FROM Element e WHERE e.designation = :designation")})
public class Element implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDELT")
    private BigDecimal idelt;
    @Size(max = 255)
    @Column(name = "DESIGNATION")
    private String designation;
    @OneToMany(mappedBy = "idelt")
    private List<Affectation> affectationList;
    @OneToMany(mappedBy = "idelt")
    private List<Souselement> souselementList;
    @JoinColumn(name = "IDGRILLE", referencedColumnName = "IDGRILLE")
    @ManyToOne
    private Grilleaudit idgrille;

    public Element() {
    }

    public Element(BigDecimal idelt) {
        this.idelt = idelt;
    }

    public BigDecimal getIdelt() {
        return idelt;
    }

    public void setIdelt(BigDecimal idelt) {
        this.idelt = idelt;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Affectation> getAffectationList() {
        return affectationList;
    }

    public void setAffectationList(List<Affectation> affectationList) {
        this.affectationList = affectationList;
    }

    public List<Souselement> getSouselementList() {
        return souselementList;
    }

    public void setSouselementList(List<Souselement> souselementList) {
        this.souselementList = souselementList;
    }

    public Grilleaudit getIdgrille() {
        return idgrille;
    }

    public void setIdgrille(Grilleaudit idgrille) {
        this.idgrille = idgrille;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idelt != null ? idelt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Element)) {
            return false;
        }
        Element other = (Element) object;
        if ((this.idelt == null && other.idelt != null) || (this.idelt != null && !this.idelt.equals(other.idelt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Element[ idelt=" + idelt + " ]";
    }
    
}
