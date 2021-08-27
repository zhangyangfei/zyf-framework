package com.zyf.busilog.common.web;

import java.util.List;

/**
 * 分页响应体
 *
 * @param <T> 分页元素类型
 */
public final class PagingResponse<T> extends WebResponse {

    public PagingResponse(List<T> list, Long totalNums, Integer page, Integer size) {
        super();
        this.list = list;
        this.totalNums = totalNums;
        this.page = page;
        this.size = size;
    }

    private final Long totalNums;
    private final Integer page;
    private final Integer size;
    private final List<T> list;

    public Long getTotalNums() {
        return totalNums;
    }

    public Integer getPage() {
        return page;
    }

    public Integer getSize() {
        return size;
    }

    public List<T> getList() {
        return list;
    }
}
