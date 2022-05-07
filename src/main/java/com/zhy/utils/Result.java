package com.zhy.utils;


import com.zhy.constant.ResultCode;

import java.io.Serializable;

/**
 * [标准规范]对内：Service 统一返回结果
 * PS：Result 注重事件结果，是否成功。以success为判断依据，以code辅助追踪错误路径，弱化code（可空）
 * 仅在将此服务以Result方式返回时，才需要设置code
 *
 * @author ding
 * @date 2020-11-24 16:27
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 3160178390672219362L;

    private String message = "";
    private int code = 0;
    private T data = null;
    private String traceId;

    public static <T> Result<T> success() {
        return new Result<T>().setCode(0);
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>().setCode(0).setData(data);
    }

    public static <T> Result<T> error(String message) {
        return new Result<T>().setCode(ResultCode.SYS_UNDEFINED).setMessage(message);
    }

    public static <T> Result<T> error(int code) {
        String message = ResultCode.CODE_MAPS.get(code);
        return new Result<T>().setCode(code).setMessage(message);
    }

    public static <T> Result<T> error(int code, String message) {
        return new Result<T>().setCode(code).setMessage(message);
    }

    public static <T> Result<T> error(int code, T data) {
        String message = ResultCode.CODE_MAPS.get(code);
        return new Result<T>().setCode(code).setData(data).setMessage(message);
    }

    public static <T> Result<T> error(int code, T data, String message) {
        return new Result<T>().setCode(code).setData(data).setMessage(message);
    }

    public static <T> Result<T> error(Result<?> result) {
        String message = result.getMessage();
        if (message.isEmpty()) {
            ResultCode.CODE_MAPS.get(result.getCode());
        }
        return new Result<T>().setCode(result.getCode()).setMessage(message);
    }

    public String getMessage() {
        return message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public boolean checkSuccess() {
        return this.getCode() == 0;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }
}
