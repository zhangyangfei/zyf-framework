package com.zyf.busilog.common.web;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * 响应信息
 */
@ApiModel("响应信息")
public class WebResponse {

    public WebResponse() {
        this.code = DEFAULT_CODE;
        this.message = "success";
    }

    public WebResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private static final String DEFAULT_CODE = "000000";

    private final String code;
    private final String message;

    public static WebResponse success() {
        return new WebResponse();
    }

    public static <T> DataResponse<T> success(T data) {
        return new DataResponse<>(data);
    }

    public static <T> PagingResponse<T> success(List<T> list, Long totalNums, Integer page, Integer size) {
        return new PagingResponse<>(list, totalNums, page, size);
    }

    public static <T> PagingResponse<T> successMyBatisPaging(List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        return new PagingResponse<>(pageInfo.getList(), pageInfo.getTotal(), pageInfo.getPageNum(), pageInfo.getPageSize());
    }

    public static WebResponse error(String code, String message) {
        return new WebResponse(code, message);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
