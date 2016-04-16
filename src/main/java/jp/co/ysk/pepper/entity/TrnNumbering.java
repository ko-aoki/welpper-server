/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ysk.pepper.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ko-aoki
 */
@Entity
@Table(name = "trn_numbering")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TrnNumbering.findAll", query = "SELECT t FROM TrnNumbering t"),
    @NamedQuery(name = "TrnNumbering.findByTrnNumberingId", query = "SELECT t FROM TrnNumbering t WHERE t.trnNumberingId = :trnNumberingId"),
    @NamedQuery(name = "TrnNumbering.findByDisplayId", query = "SELECT t FROM TrnNumbering t WHERE t.displayId = :displayId"),
    @NamedQuery(name = "TrnNumbering.findByVersionNo", query = "SELECT t FROM TrnNumbering t WHERE t.versionNo = :versionNo"),
    @NamedQuery(name = "TrnNumbering.findByInsertDate", query = "SELECT t FROM TrnNumbering t WHERE t.insertDate = :insertDate"),
    @NamedQuery(name = "TrnNumbering.findByUpdateDate", query = "SELECT t FROM TrnNumbering t WHERE t.updateDate = :updateDate"),
    @NamedQuery(name = "TrnNumbering.findByInsertUserId", query = "SELECT t FROM TrnNumbering t WHERE t.insertUserId = :insertUserId"),
    @NamedQuery(name = "TrnNumbering.findByUpdateUserId", query = "SELECT t FROM TrnNumbering t WHERE t.updateUserId = :updateUserId")})
public class TrnNumbering implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TRN_NUMBERING_ID")
    private Integer trnNumberingId;
    @Basic(optional = false)
    @Column(name = "DISPLAY_ID")
    private int displayId;
    @Column(name = "VERSION_NO")
    @Version
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

    public TrnNumbering() {
    }

    public TrnNumbering(Integer trnNumberingId) {
        this.trnNumberingId = trnNumberingId;
    }

    public TrnNumbering(Integer trnNumberingId, int displayId, Date insertDate, Date updateDate) {
        this.trnNumberingId = trnNumberingId;
        this.displayId = displayId;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
    }

    public Integer getTrnNumberingId() {
        return trnNumberingId;
    }

    public void setTrnNumberingId(Integer trnNumberingId) {
        this.trnNumberingId = trnNumberingId;
    }

    public int getDisplayId() {
        return displayId;
    }

    public void setDisplayId(int displayId) {
        this.displayId = displayId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trnNumberingId != null ? trnNumberingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TrnNumbering)) {
            return false;
        }
        TrnNumbering other = (TrnNumbering) object;
        if ((this.trnNumberingId == null && other.trnNumberingId != null) || (this.trnNumberingId != null && !this.trnNumberingId.equals(other.trnNumberingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TrnNumbering[ trnNumberingId=" + trnNumberingId + " ]";
    }
    
}
