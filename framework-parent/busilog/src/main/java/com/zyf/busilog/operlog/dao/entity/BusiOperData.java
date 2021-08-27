package com.zyf.busilog.operlog.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_BUSI_OPER_DATA_TD")
public class BusiOperData implements Serializable {

    private static final long serialVersionUID = 111761815872433378L;

    /**
     * 历史数据ID
     */
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(name = "HIS_ID")
    private String hisId;

    /**
     * 日志ID
     */
//    @Column(name = "LOG_ID")
//    private String logId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "LOG_ID", referencedColumnName = "LOG_ID")
    private BusiOperLog log;

    /**
     * 摘要
     */
    @Column(name = "DATA_ABST")
    private String dataAbst;

    /**
     * 表名
     */
    @Column(name = "TAB_NAME")
    private String tabName;

    /**
     * 业务编号
     */
    @Column(name = "BUSI_CODE")
    private String busiCode;

    /**
     * 数据JSON
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "DATA_JSON")
    private String dataJson;

    /**
     * JSON类名
     */
    @Column(name = "JSON_CLASS")
    private String jsonClass;

    public String getHisId() {
        return hisId;
    }

    public void setHisId(String hisId) {
        this.hisId = hisId;
    }

    public BusiOperLog getLog() {
        return log;
    }

    public void setLog(BusiOperLog log) {
        this.log = log;
    }

    public String getDataAbst() {
        return dataAbst;
    }

    public void setDataAbst(String dataAbst) {
        this.dataAbst = dataAbst;
    }

    public String getTabName() {
        return tabName;
    }

    public void setTabName(String tabName) {
        this.tabName = tabName;
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }

    public String getDataJson() {
        return dataJson;
    }

    public void setDataJson(String dataJson) {
        this.dataJson = dataJson;
    }

    public String getJsonClass() {
        return jsonClass;
    }

    public void setJsonClass(String jsonClass) {
        this.jsonClass = jsonClass;
    }
}
