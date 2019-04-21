/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.hse.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "GRILLEAUDIT", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Grilleaudit.findAll", query = "SELECT g FROM Grilleaudit g")
    , @NamedQuery(name = "Grilleaudit.findByIdgrille", query = "SELECT g FROM Grilleaudit g WHERE g.idgrille = :idgrille")
    , @NamedQuery(name = "Grilleaudit.findByDatevalidation", query = "SELECT g FROM Grilleaudit g WHERE g.datevalidation = :datevalidation")
    , @NamedQuery(name = "Grilleaudit.findByIdaudit", query = "SELECT g FROM Grilleaudit g WHERE g.idaudit = :idaudit")})
public class Grilleaudit implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDGRILLE")
    private BigDecimal idgrille;
    @Column(name = "DATEVALIDATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datevalidation;
    @Column(name = "IDAUDIT")
    private BigInteger idaudit;
    @JoinColumn(name = "RESPAUDIT_IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne
    private Utilisateur respauditIduser;
    @OneToMany(mappedBy = "idgrille")
    private List<Element> elementList;

    public Grilleaudit() {
    }

    public Grilleaudit(BigDecimal idgrille) {
        this.idgrille = idgrille;
    }

    public BigDecimal getIdgrille() {
        return idgrille;
    }

    public void setIdgrille(BigDecimal idgrille) {
        this.idgrille = idgrille;
    }

    public Date getDatevalidation() {
        return datevalidation;
    }

    public void setDatevalidation(Date datevalidation) {
        this.datevalidation = datevalidation;
    }

    public BigInteger getIdaudit() {
        return idaudit;
    }

    public void setIdaudit(BigInteger idaudit) {
        this.idaudit = idaudit;
    }

    public Utilisateur getRespauditIduser() {
        return respauditIduser;
    }

    public void setRespauditIduser(Utilisateur respauditIduser) {
        this.respauditIduser = respauditIduser;
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgrille != null ? idgrille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grilleaudit)) {
            return false;
        }
        Grilleaudit other = (Grilleaudit) object;
        if ((this.idgrille == null && other.idgrille != null) || (this.idgrille != null && !this.idgrille.equals(other.idgrille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Grilleaudit[ idgrille=" + idgrille + " ]";
    }
    
}
