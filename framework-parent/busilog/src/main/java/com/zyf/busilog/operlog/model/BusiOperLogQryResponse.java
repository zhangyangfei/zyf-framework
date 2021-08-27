package com.zyf.busilog.operlog.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BusiOperLogQryResponse {

    /**
     * 日志ID
     */
    @Id
    private String logId;

    /**
     * 业务编号
     */
    private String busiCode;

    /**
     * 企业ID
     */
    private String etpId;

    /**
     * 业务类型
     */
    private String busiType;

    /**
     * 业务类型文本
     */
    private String busiTypeTxt;

    /**
     * 操作类型
     */
    private String operType;

    /**
     * 操作类型文本
     */
    private String operTypeTxt;

    /**
     * 交易代码
     */
    private String tranCode;

    /**
     * 操作摘要
     */
    private String operAbst;

    /**
     * 操作结果
     */
    private String operResu;

    /**
     * 操作时间
     */
    private String operTime;

    /**
     * 操作人ID
     */
    private String operatorId;

    /**
     * 操作人姓名
     */
    private String operatorName;

    /**
     * 是否可删
     */
    private String canDelete;

    /**
     * 保留期限
     */
    private String keepTime;

    /**
     * 备注
     */
    private String note;

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

    public String getBusiTypeTxt() {
        return busiTypeTxt;
    }

    public void setBusiTypeTxt(String busiTypeTxt) {
        this.busiTypeTxt = busiTypeTxt;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getOperTypeTxt() {
        return operTypeTxt;
    }

    public void setOperTypeTxt(String operTypeTxt) {
        this.operTypeTxt = operTypeTxt;
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

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
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
}
