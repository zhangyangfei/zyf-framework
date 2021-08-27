package com.zyf.busilog.operlog.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class BusiOperCondSaveRequest {

    /**
     * 摘要
     */
    @ApiModelProperty(value = "摘要")
    @Length(max = 256, message = "摘要长度不能超过64")
    private String condAbst;

    /**
     * 条件数据
     */
    @ApiModelProperty(value = "条件数据")
    @NotNull(message = "条件数据不能为空")
    private Object condData;

    public String getCondAbst() {
        return condAbst;
    }

    public void setCondAbst(String condAbst) {
        this.condAbst = condAbst;
    }

    public Object getCondData() {
        return condData;
    }

    public void setCondData(Object condData) {
        this.condData = condData;
    }
}
