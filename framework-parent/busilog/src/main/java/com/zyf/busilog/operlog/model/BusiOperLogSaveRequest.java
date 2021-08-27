package com.zyf.busilog.operlog.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class BusiOperLogSaveRequest {

    public BusiOperLogSaveRequest() {
    }

    public BusiOperLogSaveRequest(String busiType, String operType, String tranCode, String operAbst) {
        this.busiType = busiType;
        this.operType = operType;
        this.tranCode = tranCode;
        this.operAbst = operAbst;
    }

    /**
     * 业务编号
     */
    @ApiModelProperty(value = "业务编号")
    @Length(max = 36, message = "业务编号长度不能超过36")
    private String busiCode;

    /**
     * 企业ID
     */
    @ApiModelProperty(value = "企业ID", required = true)
    @Length(max = 36, message = "企业ID长度不能超过36")
    private String etpId;

    /**
     * 业务类型
     */
    @ApiModelProperty(value = "业务类型", required = true)
    @NotEmpty(message = "业务类型不能为空")
    @Length(max = 32, message = "业务类型长度不能超过32")
    private String busiType;

    /**
     * 操作类型
     */
    @ApiModelProperty(value = "操作类型", required = true)
    @NotEmpty(message = "操作类型不能为空")
    @Length(max = 32, message = "操作类型长度不能超过32")
    private String operType;

    /**
     * 交易代码
     */
    @ApiModelProperty(value = "交易代码", required = true)
    @NotEmpty(message = "交易代码不能为空")
    @Length(max = 128, message = "交易代码长度不能超过128")
    private String tranCode;

    /**
     * 操作摘要
     */
    @ApiModelProperty(value = "操作摘要")
    @NotEmpty(message = "操作摘要不能为空")
    @Length(max = 256, message = "操作摘要长度不能超过256")
    private String operAbst;

    /**
     * 操作结果
     */
    @ApiModelProperty(value = "操作结果")
    @Length(max = 128, message = "操作结果长度不能超过128")
    private String operResu;

    /**
     * 操作时间
     */
    @ApiModelProperty(value = "操作时间，yyyy-MM-dd HH:mm:ss")
    @Length(max = 26, message = "操作时间长度不能超过26")
    private String operTime;

    /**
     * 操作人ID
     */
    @ApiModelProperty(value = "操作人ID", required = true)
    @Length(max = 36, message = "操作人ID长度不能超过36")
    private String operatorId;

    /**
     * 是否可删
     */
    @ApiModelProperty(value = "是否可删")
    @Length(max = 2, message = "是否可删长度不能超过2")
    private String canDelete;

    /**
     * 保留时长(月)
     */
    @ApiModelProperty(value = "保留时长")
    private int keepLong;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @Length(max = 128, message = "交易代码长度不能超过128")
    private String note;

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

    public int getKeepLong() {
        return keepLong;
    }

    public void setKeepLong(int keepLong) {
        this.keepLong = keepLong;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
