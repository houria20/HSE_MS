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
import javax.validation.constraints.Size;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "LISTEAUDIT", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Listeaudit.findAll", query = "SELECT l FROM Listeaudit l")
    , @NamedQuery(name = "Listeaudit.findByIdaudit", query = "SELECT l FROM Listeaudit l WHERE l.idaudit = :idaudit")
    , @NamedQuery(name = "Listeaudit.findByDatedebaudit", query = "SELECT l FROM Listeaudit l WHERE l.datedebaudit = :datedebaudit")
    , @NamedQuery(name = "Listeaudit.findByDatefinaudit", query = "SELECT l FROM Listeaudit l WHERE l.datefinaudit = :datefinaudit")
    , @NamedQuery(name = "Listeaudit.findByTypeaudit", query = "SELECT l FROM Listeaudit l WHERE l.typeaudit = :typeaudit")})
public class Listeaudit implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDAUDIT")
    private BigDecimal idaudit;
    @Column(name = "DATEDEBAUDIT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebaudit;
    @Column(name = "DATEFINAUDIT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefinaudit;
    @Size(max = 255)
    @Column(name = "TYPEAUDIT")
    private String typeaudit;
    @OneToMany(mappedBy = "idaudit")
    private List<Affectation> affectationList;
    @OneToMany(mappedBy = "idaudit")
    private List<Resultats> resultatsList;
    @JoinColumn(name = "IDEQUIPE", referencedColumnName = "IDEQUIPE")
    @ManyToOne
    private Equipeaudit idequipe;
    @JoinColumn(name = "IDSITE", referencedColumnName = "IDSITE")
    @ManyToOne
    private Site idsite;

    public Listeaudit() {
    }

    public Listeaudit(BigDecimal idaudit) {
        this.idaudit = idaudit;
    }

    public BigDecimal getIdaudit() {
        return idaudit;
    }

    public void setIdaudit(BigDecimal idaudit) {
        this.idaudit = idaudit;
    }

    public Date getDatedebaudit() {
        return datedebaudit;
    }

    public void setDatedebaudit(Date datedebaudit) {
        this.datedebaudit = datedebaudit;
    }

    public Date getDatefinaudit() {
        return datefinaudit;
    }

    public void setDatefinaudit(Date datefinaudit) {
        this.datefinaudit = datefinaudit;
    }

    public String getTypeaudit() {
        return typeaudit;
    }

    public void setTypeaudit(String typeaudit) {
        this.typeaudit = typeaudit;
    }

    public List<Affectation> getAffectationList() {
        return affectationList;
    }

    public void setAffectationList(List<Affectation> affectationList) {
        this.affectationList = affectationList;
    }

    public List<Resultats> getResultatsList() {
        return resultatsList;
    }

    public void setResultatsList(List<Resultats> resultatsList) {
        this.resultatsList = resultatsList;
    }

    public Equipeaudit getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(Equipeaudit idequipe) {
        this.idequipe = idequipe;
    }

    public Site getIdsite() {
        return idsite;
    }

    public void setIdsite(Site idsite) {
        this.idsite = idsite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaudit != null ? idaudit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listeaudit)) {
            return false;
        }
        Listeaudit other = (Listeaudit) object;
        if ((this.idaudit == null && other.idaudit != null) || (this.idaudit != null && !this.idaudit.equals(other.idaudit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Listeaudit[ idaudit=" + idaudit + " ]";
    }
    
}
