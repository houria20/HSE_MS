/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.hse.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "EQUIPEAUDIT", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Equipeaudit.findAll", query = "SELECT e FROM Equipeaudit e")
    , @NamedQuery(name = "Equipeaudit.findByIdequipe", query = "SELECT e FROM Equipeaudit e WHERE e.idequipe = :idequipe")
    , @NamedQuery(name = "Equipeaudit.findByDtype", query = "SELECT e FROM Equipeaudit e WHERE e.dtype = :dtype")
    , @NamedQuery(name = "Equipeaudit.findByIdstructure", query = "SELECT e FROM Equipeaudit e WHERE e.idstructure = :idstructure")
    , @NamedQuery(name = "Equipeaudit.findByTypecp", query = "SELECT e FROM Equipeaudit e WHERE e.typecp = :typecp")})
public class Equipeaudit implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEQUIPE")
    private BigDecimal idequipe;
    @Size(max = 31)
    @Column(name = "DTYPE")
    private String dtype;
    @Column(name = "IDSTRUCTURE")
    private BigInteger idstructure;
    @Size(max = 255)
    @Column(name = "TYPECP")
    private String typecp;
    @JoinColumn(name = "RESPAUDIT_IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne
    private Utilisateur respauditIduser;
    @OneToMany(mappedBy = "idequipe")
    private List<Membreaudit> membreauditList;
    @OneToMany(mappedBy = "idequipe")
    private List<Listeaudit> listeauditList;

    public Equipeaudit() {
    }

    public Equipeaudit(BigDecimal idequipe) {
        this.idequipe = idequipe;
    }

    public BigDecimal getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(BigDecimal idequipe) {
        this.idequipe = idequipe;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    public BigInteger getIdstructure() {
        return idstructure;
    }

    public void setIdstructure(BigInteger idstructure) {
        this.idstructure = idstructure;
    }

    public String getTypecp() {
        return typecp;
    }

    public void setTypecp(String typecp) {
        this.typecp = typecp;
    }

    public Utilisateur getRespauditIduser() {
        return respauditIduser;
    }

    public void setRespauditIduser(Utilisateur respauditIduser) {
        this.respauditIduser = respauditIduser;
    }

    public List<Membreaudit> getMembreauditList() {
        return membreauditList;
    }

    public void setMembreauditList(List<Membreaudit> membreauditList) {
        this.membreauditList = membreauditList;
    }

    public List<Listeaudit> getListeauditList() {
        return listeauditList;
    }

    public void setListeauditList(List<Listeaudit> listeauditList) {
        this.listeauditList = listeauditList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequipe != null ? idequipe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipeaudit)) {
            return false;
        }
        Equipeaudit other = (Equipeaudit) object;
        if ((this.idequipe == null && other.idequipe != null) || (this.idequipe != null && !this.idequipe.equals(other.idequipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Equipeaudit[ idequipe=" + idequipe + " ]";
    }
    
}
