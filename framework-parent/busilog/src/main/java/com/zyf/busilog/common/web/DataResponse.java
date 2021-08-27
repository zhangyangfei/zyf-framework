package com.zyf.busilog.common.web;

/**
 * 数据响应体
 *
 * @param <T> 响应内容类型
 */
public final class DataResponse<T> extends WebResponse {

    public DataResponse(T data) {
        super();
        this.data = data;
    }

    private final T data;



    public T getData() {
        return data;
    }
}
