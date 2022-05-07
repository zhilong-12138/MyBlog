package com.zhy.utils;


import com.zhy.constant.ResultCode;

import java.io.Serializable;

/**
 * 分页Result
 *
 * @author ding
 * @date 2021-04-09 09:14
 */

public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -6589798725304454185L;

    private String msg = "";
    private int code = 0;
    private Integer count;
    /**
     * 为获取下一页的标识
     */
    private String marker;
    private T data = null;
    private String traceId;

    public static <T> PageResult<T> success() {
        return new PageResult<T>().setCode(0).setCount(0);
    }

    public static <T> PageResult<T> success(T data) {
        return new PageResult<T>().setCode(0).setData(data);
    }

    public static <T> PageResult<T> success(T data, String marker) {
        return new PageResult<T>().setCode(0).setData(data).setMarker(marker);
    }

    public static <T> PageResult<T> success(T data, Integer count) {
        return new PageResult<T>().setCode(0).setData(data).setCount(count);
    }

    public static <T> PageResult<T> success(T data, Integer count, String marker) {
        return new PageResult<T>().setCode(0).setData(data).setCount(count).setMarker(marker);
    }

    public static <T> Result<T> error(String message) {
        return new Result<T>().setCode(ResultCode.SYS_UNDEFINED).setMessage(message);
    }

    public static <T> PageResult<T> error(int code) {
        String message = ResultCode.CODE_MAPS.get(code);
        return new PageResult<T>().setCode(code).setCount(0).setMsg(message);
    }

    public static <T> PageResult<T> error(Result<?> result) {
        String message = result.getMessage();
        if (message.isEmpty()) {
            ResultCode.CODE_MAPS.get(result.getCode());
        }
        return new PageResult<T>().setCode(result.getCode()).setMsg(message).setCount(0);
    }

    public static <T> PageResult<T> error(PageResult<?> result) {
        String message = result.getMsg();
        if (message.isEmpty()) {
            ResultCode.CODE_MAPS.get(result.getCode());
        }
        return new PageResult<T>().setCode(result.getCode()).setMsg(message).setCount(0);
    }

    public static <T> PageResult<T> error(int code, String message) {
        return new PageResult<T>().setCode(code).setCount(0).setMsg(message);
    }

    public static <T> PageResult<T> error(int code, T data) {
        String message = ResultCode.CODE_MAPS.get(code);
        return new PageResult<T>().setCode(code).setCount(0).setData(data).setMsg(message);
    }

    public static <T> PageResult<T> error(int code, T data, String message) {
        return new PageResult<T>().setCode(code).setCount(0).setData(data).setMsg(message);
    }

    public String getMsg() {
        return msg;
    }

    public PageResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public PageResult<T> setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Object getMarker() {
        return marker;
    }

    public PageResult<T> setMarker(String marker) {
        this.marker = marker;
        return this;
    }

    public boolean checkSuccess() {
        return this.getCode() == 0;
    }

    public T getData() {
        return data;
    }

    public PageResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }

    public PageResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

}
