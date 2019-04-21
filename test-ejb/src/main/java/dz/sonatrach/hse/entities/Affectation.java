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

/**
 *
 * @author pc
 */
@Entity
@Table(name = "AFFECTATION", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Affectation.findAll", query = "SELECT a FROM Affectation a")
    , @NamedQuery(name = "Affectation.findByIdaffectation", query = "SELECT a FROM Affectation a WHERE a.idaffectation = :idaffectation")})
public class Affectation implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDAFFECTATION")
    private BigDecimal idaffectation;
    @JoinColumn(name = "IDELT", referencedColumnName = "IDELT")
    @ManyToOne
    private Element idelt;
    @JoinColumn(name = "IDAUDIT", referencedColumnName = "IDAUDIT")
    @ManyToOne
    private Listeaudit idaudit;
    @JoinColumn(name = "IDMEMBRE", referencedColumnName = "IDUSER")
    @ManyToOne
    private Utilisateur idmembre;

    public Affectation() {
    }

    public Affectation(BigDecimal idaffectation) {
        this.idaffectation = idaffectation;
    }

    public BigDecimal getIdaffectation() {
        return idaffectation;
    }

    public void setIdaffectation(BigDecimal idaffectation) {
        this.idaffectation = idaffectation;
    }

    public Element getIdelt() {
        return idelt;
    }

    public void setIdelt(Element idelt) {
        this.idelt = idelt;
    }

    public Listeaudit getIdaudit() {
        return idaudit;
    }

    public void setIdaudit(Listeaudit idaudit) {
        this.idaudit = idaudit;
    }

    public Utilisateur getIdmembre() {
        return idmembre;
    }

    public void setIdmembre(Utilisateur idmembre) {
        this.idmembre = idmembre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaffectation != null ? idaffectation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Affectation)) {
            return false;
        }
        Affectation other = (Affectation) object;
        if ((this.idaffectation == null && other.idaffectation != null) || (this.idaffectation != null && !this.idaffectation.equals(other.idaffectation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Affectation[ idaffectation=" + idaffectation + " ]";
    }
    
}
