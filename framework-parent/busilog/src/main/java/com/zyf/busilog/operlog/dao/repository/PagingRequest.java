package com.zyf.busilog.operlog.dao.repository;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页请求")
public class PagingRequest {

    @ApiModelProperty("页号(default = 1)")
    private Integer page = 1;
    @ApiModelProperty("每页记录数")
    private Integer size;


    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
