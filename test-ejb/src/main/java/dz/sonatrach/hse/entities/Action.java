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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "ACTION", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Action.findAll", query = "SELECT a FROM Action a")
    , @NamedQuery(name = "Action.findByIdaction", query = "SELECT a FROM Action a WHERE a.idaction = :idaction")
    , @NamedQuery(name = "Action.findByDatedebaction", query = "SELECT a FROM Action a WHERE a.datedebaction = :datedebaction")
    , @NamedQuery(name = "Action.findByDatefinaction", query = "SELECT a FROM Action a WHERE a.datefinaction = :datefinaction")
    , @NamedQuery(name = "Action.findByDescription", query = "SELECT a FROM Action a WHERE a.description = :description")
    , @NamedQuery(name = "Action.findByEtatavanc", query = "SELECT a FROM Action a WHERE a.etatavanc = :etatavanc")
    , @NamedQuery(name = "Action.findByIdexigence", query = "SELECT a FROM Action a WHERE a.idexigence = :idexigence")
    , @NamedQuery(name = "Action.findByIdsite", query = "SELECT a FROM Action a WHERE a.idsite = :idsite")
    , @NamedQuery(name = "Action.findByRemarque", query = "SELECT a FROM Action a WHERE a.remarque = :remarque")
    , @NamedQuery(name = "Action.findByRespaction", query = "SELECT a FROM Action a WHERE a.respaction = :respaction")})
public class Action implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDACTION")
    private BigDecimal idaction;
    @Column(name = "DATEDEBACTION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datedebaction;
    @Column(name = "DATEFINACTION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefinaction;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ETATAVANC")
    private BigDecimal etatavanc;
    @Column(name = "IDEXIGENCE")
    private BigInteger idexigence;
    @Column(name = "IDSITE")
    private BigInteger idsite;
    @Size(max = 255)
    @Column(name = "REMARQUE")
    private String remarque;
    @Size(max = 255)
    @Column(name = "RESPACTION")
    private String respaction;
    @JoinColumn(name = "IDPLAN", referencedColumnName = "IDPLAN")
    @ManyToOne
    private Plandaction idplan;

    public Action() {
    }

    public Action(BigDecimal idaction) {
        this.idaction = idaction;
    }

    public BigDecimal getIdaction() {
        return idaction;
    }

    public void setIdaction(BigDecimal idaction) {
        this.idaction = idaction;
    }

    public Date getDatedebaction() {
        return datedebaction;
    }

    public void setDatedebaction(Date datedebaction) {
        this.datedebaction = datedebaction;
    }

    public Date getDatefinaction() {
        return datefinaction;
    }

    public void setDatefinaction(Date datefinaction) {
        this.datefinaction = datefinaction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getEtatavanc() {
        return etatavanc;
    }

    public void setEtatavanc(BigDecimal etatavanc) {
        this.etatavanc = etatavanc;
    }

    public BigInteger getIdexigence() {
        return idexigence;
    }

    public void setIdexigence(BigInteger idexigence) {
        this.idexigence = idexigence;
    }

    public BigInteger getIdsite() {
        return idsite;
    }

    public void setIdsite(BigInteger idsite) {
        this.idsite = idsite;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public String getRespaction() {
        return respaction;
    }

    public void setRespaction(String respaction) {
        this.respaction = respaction;
    }

    public Plandaction getIdplan() {
        return idplan;
    }

    public void setIdplan(Plandaction idplan) {
        this.idplan = idplan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaction != null ? idaction.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Action)) {
            return false;
        }
        Action other = (Action) object;
        if ((this.idaction == null && other.idaction != null) || (this.idaction != null && !this.idaction.equals(other.idaction))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Action[ idaction=" + idaction + " ]";
    }
    
}
