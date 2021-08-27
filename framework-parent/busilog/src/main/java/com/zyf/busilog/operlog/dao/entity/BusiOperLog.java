package com.zyf.busilog.operlog.dao.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "T_BUSI_OPER_LOG_TD")
public class BusiOperLog implements Serializable {

    private static final long serialVersionUID = 9038148070658044998L;

    /**
     * 日志ID
     */
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @Column(name = "LOG_ID")
    private String logId;

    /**
     * 业务编号
     */
    @Column(name = "BUSI_CODE")
    private String busiCode;

    /**
     * 企业ID
     */
    @Column(name = "ETP_ID")
    private String etpId;

    /**
     * 业务类型
     */
    @Column(name = "BUSI_TYPE")
    private String busiType;

    /**
     * 操作类型
     */
    @Column(name = "OPER_TYPE")
    private String operType;

    /**
     * 交易代码
     */
    @Column(name = "TRAN_CODE")
    private String tranCode;

    /**
     * 操作摘要
     */
    @Column(name = "OPER_ABST")
    private String operAbst;

    /**
     * 操作结果
     */
    @Column(name = "OPER_RESU")
    private String operResu;

    /**
     * 操作时间
     */
    @Column(name = "OPER_TIME")
    private String operTime;

    /**
     * 操作人ID
     */
    @Column(name = "OPERATOR_ID")
    private String operatorId;

    /**
     * 是否可删
     */
    @Column(name = "CAN_DELETE")
    private String canDelete;

    /**
     * 保留期限
     */
    @Column(name = "KEEP_TIME")
    private String keepTime;

    /**
     * 备注
     */
    @Column(name = "NOTE")
    private String note;

    /**
     * 条件数据
     */
//    @JsonIgnore
//    @OneToMany(mappedBy = "log", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @OneToMany(mappedBy = "log", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private List<BusiOperCond> conds = new ArrayList<>(0);

    /**
     * 历史数据
     */
//    @JsonIgnore
//    @OneToMany(mappedBy = "log", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @OneToMany(mappedBy = "log", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    private List<BusiOperData> datas = new ArrayList<>(0);

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getBusiCode() {
        return busiCode;
    }

    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }

    public String getEtpId() {
        return etpId;
    }

    public void setEtpId(String etpId) {
        this.etpId = etpId;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }

    public String getOperAbst() {
        return operAbst;
    }

    public void setOperAbst(String operAbst) {
        this.operAbst = operAbst;
    }

    public String getOperResu() {
        return operResu;
    }

    public void setOperResu(String operResu) {
        this.operResu = operResu;
    }

    public String getOperTime() {
        return operTime;
    }

    public void setOperTime(String operTime) {
        this.operTime = operTime;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getCanDelete() {
        return canDelete;
    }

    public void setCanDelete(String canDelete) {
        this.canDelete = canDelete;
    }

    public String getKeepTime() {
        return keepTime;
    }

    public void setKeepTime(String keepTime) {
        this.keepTime = keepTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<BusiOperData> getDatas() {
        return datas;
    }

    public void setDatas(List<BusiOperData> datas) {
        this.datas = datas;
    }

    public List<BusiOperCond> getConds() {
        return conds;
    }

    public void setConds(List<BusiOperCond> conds) {
        this.conds = conds;
    }
}
