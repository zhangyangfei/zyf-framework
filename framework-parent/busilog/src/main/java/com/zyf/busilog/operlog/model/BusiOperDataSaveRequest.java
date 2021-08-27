package com.zyf.busilog.operlog.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class BusiOperDataSaveRequest {

    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    @Length(max = 256, message = "摘要长度不能超过64")
    private String dataAbst;

    /**
     * 表名
     */
    @ApiModelProperty(value = "表名")
    @Length(max = 64, message = "表名长度不能超过64")
    private String tabName;

    /**
     * 业务编号
     */
    @ApiModelProperty(value = "业务编号")
    @Length(max = 36, message = "业务编号长度不能超过36")
    private String busiCode;

    /**
     * 历史数据
     */
    @ApiModelProperty(value = "历史数据")
    @NotNull(message = "历史数据不能为空")
    private Object hisData;

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

    public Object getHisData() {
        return hisData;
    }

    public void setHisData(Object hisData) {
        this.hisData = hisData;
    }

}
