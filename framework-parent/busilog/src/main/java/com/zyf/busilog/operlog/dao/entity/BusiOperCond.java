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
@Table(name = "T_BUSI_OPER_COND_TD")
public class BusiOperCond implements Serializable {

    private static final long serialVersionUID = 6265956385759488351L;

    /**
     * 条件ID
     */
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(name = "COND_ID")
    private String condId;

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
    @Column(name = "ABST")
    private String abst;

    /**
     * 条件JSON
     */
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "COND_JSON")
    private String condJson;

    /**
     * JSON类名
     */
    @Column(name = "JSON_CLASS")
    private String jsonClass;

    public String getCondId() {
        return condId;
    }

    public void setCondId(String condId) {
        this.condId = condId;
    }

    public BusiOperLog getLog() {
        return log;
    }

    public void setLog(BusiOperLog log) {
        this.log = log;
    }

    public String getAbst() {
        return abst;
    }

    public void setAbst(String abst) {
        this.abst = abst;
    }

    public String getCondJson() {
        return condJson;
    }

    public void setCondJson(String condJson) {
        this.condJson = condJson;
    }

    public String getJsonClass() {
        return jsonClass;
    }

    public void setJsonClass(String jsonClass) {
        this.jsonClass = jsonClass;
    }
}
