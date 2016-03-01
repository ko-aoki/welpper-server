/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ysk.pepper.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ko-aoki
 */
@Entity
@Table(name = "mst_window")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MstWindow.findAll", query = "SELECT m FROM MstWindow m"),
    @NamedQuery(name = "MstWindow.findByWindowId", query = "SELECT m FROM MstWindow m WHERE m.windowId = :windowId"),
    @NamedQuery(name = "MstWindow.findByWindoNm", query = "SELECT m FROM MstWindow m WHERE m.windoNm = :windoNm"),
    @NamedQuery(name = "MstWindow.findByVersionNo", query = "SELECT m FROM MstWindow m WHERE m.versionNo = :versionNo"),
    @NamedQuery(name = "MstWindow.findByInsertDate", query = "SELECT m FROM MstWindow m WHERE m.insertDate = :insertDate"),
    @NamedQuery(name = "MstWindow.findByUpdateDate", query = "SELECT m FROM MstWindow m WHERE m.updateDate = :updateDate"),
    @NamedQuery(name = "MstWindow.findByInsertUserId", query = "SELECT m FROM MstWindow m WHERE m.insertUserId = :insertUserId"),
    @NamedQuery(name = "MstWindow.findByUpdateUserId", query = "SELECT m FROM MstWindow m WHERE m.updateUserId = :updateUserId")})
public class MstWindow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "WINDOW_ID")
    private String windowId;
    @Column(name = "WINDO_NM")
    private String windoNm;
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
    @OneToMany(mappedBy = "windowId")
    private Collection<TrnReception> trnReceptionCollection;

    public MstWindow() {
    }

    public MstWindow(String windowId) {
        this.windowId = windowId;
    }

    public MstWindow(String windowId, Date insertDate, Date updateDate) {
        this.windowId = windowId;
        this.insertDate = insertDate;
        this.updateDate = updateDate;
    }

    public String getWindowId() {
        return windowId;
    }

    public void setWindowId(String windowId) {
        this.windowId = windowId;
    }

    public String getWindoNm() {
        return windoNm;
    }

    public void setWindoNm(String windoNm) {
        this.windoNm = windoNm;
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

    @XmlTransient
    public Collection<TrnReception> getTrnReceptionCollection() {
        return trnReceptionCollection;
    }

    public void setTrnReceptionCollection(Collection<TrnReception> trnReceptionCollection) {
        this.trnReceptionCollection = trnReceptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (windowId != null ? windowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MstWindow)) {
            return false;
        }
        MstWindow other = (MstWindow) object;
        if ((this.windowId == null && other.windowId != null) || (this.windowId != null && !this.windowId.equals(other.windowId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.MstWindow[ windowId=" + windowId + " ]";
    }
    
}
