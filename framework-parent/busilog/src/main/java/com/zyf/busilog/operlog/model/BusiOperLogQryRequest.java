package com.zyf.busilog.operlog.model;

import com.zyf.busilog.operlog.dao.repository.PagingRequest;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class BusiOperLogQryRequest extends PagingRequest {

    @ApiModelProperty("每页记录数（默认10）")
    @NotNull(message = "每页记录数不能为空")
    @Max(value = 500, message = "每页记录数最大值为500")
    @Min(value = 1, message = "每页记录数最小值为1")
    private Integer size = 10;

    /**
     * 业务编号
     */
    @ApiModelProperty(value = "业务编号")
    @Length(max = 36, message = "长度不能超过36")
    private String busiCode;

    /**
     * 企业ID
     */
    @ApiModelProperty(value = "企业ID")
    @Length(max = 36, message = "企业ID长度不能超过36")
    @NotEmpty(message = "企业ID不能为空")
    private String etpId;

    /**
     * 业务类型
     */
    @ApiModelProperty(value = "业务类型数组")
    private List<String> busiTypes;

    /**
     * 操作类型
     */
    @ApiModelProperty(value = "操作类型数组")
    private List<String> operTypes;

    /**
     * 交易代码
     */
    @ApiModelProperty(value = "交易代码")
    @Length(max = 128, message = "长度不能超过128")
    private String tranCode;

    /**
     * 操作摘要
     */
    @ApiModelProperty(value = "操作摘要")
    private String operAbst;

    /**
     * 操作结果
     */
    @ApiModelProperty(value = "操作结果")
    @Length(max = 2, message = "长度不能超过2")
    private String operResu;

    /**
     * 操作时间Start
     */
    @ApiModelProperty(value = "操作时间Start，yyyy-MM-dd或者yyyy-MM-dd HH:mm:ss")
    @Length(max = 26, message = "操作时间Start长度不能超过26")
    private String operTimeStart;

    /**
     * 操作时间End
     */
    @ApiModelProperty(value = "操作时间End，yyyy-MM-dd或者yyyy-MM-dd HH:mm:ss")
    @Length(max = 26, message = "操作时间End长度不能超过26")
    private String operTimeEnd;

    /**
     * 操作人ID
     */
    @ApiModelProperty(value = "操作人ID")
    @Length(max = 36, message = "长度不能超过36")
    private String operatorId;

    /**
     * 操作人姓名
     */
    @ApiModelProperty(value = "操作人姓名")
    @Length(max = 36, message = "长度不能超过36")
    private String operatorName;

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

    public List<String> getBusiTypes() {
        return busiTypes;
    }

    public void setBusiTypes(List<String> busiTypes) {
        this.busiTypes = busiTypes;
    }

    public List<String> getOperTypes() {
        return operTypes;
    }

    public void setOperTypes(List<String> operTypes) {
        this.operTypes = operTypes;
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

    public String getOperTimeStart() {
        return operTimeStart;
    }

    public void setOperTimeStart(String operTimeStart) {
        this.operTimeStart = operTimeStart;
    }

    public String getOperTimeEnd() {
        return operTimeEnd;
    }

    public void setOperTimeEnd(String operTimeEnd) {
        this.operTimeEnd = operTimeEnd;
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

    @Override
    public Integer getSize() {
        return size;
    }

    @Override
    public void setSize(Integer size) {
        this.size = size;
    }
}
