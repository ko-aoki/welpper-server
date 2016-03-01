/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ysk.pepper.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ko-aoki
 */
@Entity
@Table(name = "trn_reception")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrnReception.findAll", query = "SELECT t FROM TrnReception t"),
    @NamedQuery(name = "TrnReception.findByTrnReceptionId", query = "SELECT t FROM TrnReception t WHERE t.trnReceptionId = :trnReceptionId"),
    @NamedQuery(name = "TrnReception.findByDisplayId", query = "SELECT t FROM TrnReception t WHERE t.displayId = :displayId"),
    @NamedQuery(name = "TrnReception.findByPreviousWindowId", query = "SELECT t FROM TrnReception t WHERE t.previousWindowId = :previousWindowId"),
    @NamedQuery(name = "TrnReception.findByStatusCd", query = "SELECT t FROM TrnReception t WHERE t.statusCd = :statusCd"),
    @NamedQuery(name = "TrnReception.findByIsActive", query = "SELECT t FROM TrnReception t WHERE t.isActive = :isActive"),
    @NamedQuery(name = "TrnReception.findByVersionNo", query = "SELECT t FROM TrnReception t WHERE t.versionNo = :versionNo"),
    @NamedQuery(name = "TrnReception.findByInsertDate", query = "SELECT t FROM TrnReception t WHERE t.insertDate = :insertDate"),
    @NamedQuery(name = "TrnReception.findByUpdateDate", query = "SELECT t FROM TrnReception t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TrnReception.findByInsertUserId", query = "SELECT t FROM TrnReception t WHERE t.insertUserId = :insertUserId"),
    @NamedQuery(name = "TrnReception.findByUpdateUserId", query = "SELECT t FROM TrnReception t WHERE t.updateUserId = :updateUserId")})
public class TrnReception implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TRN_RECEPTION_ID")
    private Integer trnReceptionId;
    @Column(name = "DISPLAY_ID")
    private Integer displayId;
    @Column(name = "PREVIOUS_WINDOW_ID")
    private String previousWindowId;
    @Column(name = "STATUS_CD")
    private String statusCd;
    @Column(name = "IS_ACTIVE")
    private Character isActive;
    @Column(name = "VERSION_NO")
    private Integer versionNo;
    @Basic(optional = false)
    @Column(name = "INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @Basic(optional = false)
    @Column(name = "UPDATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
    @Column(name = "INSERT_USER_ID")
    private String insertUserId;
    @Column(name = "UPDATE_USER_ID")
    private String updateUserId;
    @JoinColumn(name = "WINDOW_ID", referencedColumnName = "WINDOW_ID")
    @ManyToOne
    private MstWindow windowId;

    public TrnReception() {
    }

    public TrnReception(Integer trnReceptionId) {
        this.trnReceptionId = trnReceptionId;
    }

    public TrnReception(Integer trnReceptionId, Date insertDate, Date updateDate) {
        this.trnReceptionId = trnReceptionId;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
    }

    public Integer getTrnReceptionId() {
        return trnReceptionId;
    }

    public void setTrnReceptionId(Integer trnReceptionId) {
        this.trnReceptionId = trnReceptionId;
    }

    public Integer getDisplayId() {
        return displayId;
    }

    public void setDisplayId(Integer displayId) {
        this.displayId = displayId;
    }

    public String getPreviousWindowId() {
        return previousWindowId;
    }

    public void setPreviousWindowId(String previousWindowId) {
        this.previousWindowId = previousWindowId;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public Character getIsActive() {
        return isActive;
    }

    public void setIsActive(Character isActive) {
        this.isActive = isActive;
    }

    public Integer getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Integer versionNo) {
        this.versionNo = versionNo;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getInsertUserId() {
        return insertUserId;
    }

    public void setInsertUserId(String insertUserId) {
        this.insertUserId = insertUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public MstWindow getWindowId() {
        return windowId;
    }

    public void setWindowId(MstWindow windowId) {
        this.windowId = windowId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trnReceptionId != null ? trnReceptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrnReception)) {
            return false;
        }
        TrnReception other = (TrnReception) object;
        if ((this.trnReceptionId == null && other.trnReceptionId != null) || (this.trnReceptionId != null && !this.trnReceptionId.equals(other.trnReceptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TrnReception[ trnReceptionId=" + trnReceptionId + " ]";
    }
    
}
