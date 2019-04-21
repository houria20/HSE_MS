/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.sonatrach.hse.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "CP", catalog = "", schema = "HSEMS_DB")
@NamedQueries({
    @NamedQuery(name = "Cp.findAll", query = "SELECT c FROM Cp c")
    , @NamedQuery(name = "Cp.findByIdcp", query = "SELECT c FROM Cp c WHERE c.idcp = :idcp")
    , @NamedQuery(name = "Cp.findByIdequipe", query = "SELECT c FROM Cp c WHERE c.idequipe = :idequipe")
    , @NamedQuery(name = "Cp.findByTypecp", query = "SELECT c FROM Cp c WHERE c.typecp = :typecp")
    , @NamedQuery(name = "Cp.findByIdstructure", query = "SELECT c FROM Cp c WHERE c.idstructure = :idstructure")})
public class Cp implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCP")
    private BigDecimal idcp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEQUIPE")
    private BigInteger idequipe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TYPECP")
    private String typecp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDSTRUCTURE")
    private BigInteger idstructure;

    public Cp() {
    }

    public Cp(BigDecimal idcp) {
        this.idcp = idcp;
    }

    public Cp(BigDecimal idcp, BigInteger idequipe, String typecp, BigInteger idstructure) {
        this.idcp = idcp;
        this.idequipe = idequipe;
        this.typecp = typecp;
        this.idstructure = idstructure;
    }

    public BigDecimal getIdcp() {
        return idcp;
    }

    public void setIdcp(BigDecimal idcp) {
        this.idcp = idcp;
    }

    public BigInteger getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(BigInteger idequipe) {
        this.idequipe = idequipe;
    }

    public String getTypecp() {
        return typecp;
    }

    public void setTypecp(String typecp) {
        this.typecp = typecp;
    }

    public BigInteger getIdstructure() {
        return idstructure;
    }

    public void setIdstructure(BigInteger idstructure) {
        this.idstructure = idstructure;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcp != null ? idcp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cp)) {
            return false;
        }
        Cp other = (Cp) object;
        if ((this.idcp == null && other.idcp != null) || (this.idcp != null && !this.idcp.equals(other.idcp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.sonatrach.hse.entities.Cp[ idcp=" + idcp + " ]";
    }
    
}
