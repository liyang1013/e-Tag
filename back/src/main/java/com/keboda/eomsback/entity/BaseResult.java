package com.keboda.eomsback.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 默认接口返回格式
 */
@Data
public class BaseResult implements Serializable {
    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FALL = 500;

    private int status;
    private String message;
    private Object result;
    private long total;
    private long timestamp = System.currentTimeMillis();

    /**
     * 创建返回对象
     *
     * @param status  返回状态
     * @param message 返回消息
     * @param result  返回数据
     * @return baseResult
     */
    private static BaseResult createResult(int status, String message, Object result,long total) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        baseResult.setResult(result);
        baseResult.setTotal(total);
        return baseResult;
    }

    /**
     * 默认返回成功方法
     */
    public static BaseResult success() {
        return BaseResult.createResult(STATUS_SUCCESS, "成功", null,1);
    }

    /**
     * 返回成功带消息
     */
    public static BaseResult success(String message) {
        return BaseResult.createResult(STATUS_SUCCESS, message, null,1);
    }

    /**
     * 返回成功带消息和对象
     */
    public static BaseResult success(Object result,String message) {
        return BaseResult.createResult(STATUS_SUCCESS, message, result,1);
    }

    /**
     * 返回成功带数据
     */
    public static BaseResult success(Object result) {
        return BaseResult.createResult(STATUS_SUCCESS, "成功", result,1);
    }

    /**
     * 返回成功带数据
     */
    public static BaseResult success(Object result,long total) {
        return BaseResult.createResult(STATUS_SUCCESS, "成功", result,total);
    }

    /**
     * 返回成功带消息和数据
     */
    public static BaseResult success(String message, Object result,long total) {
        return BaseResult.createResult(STATUS_SUCCESS, message, result,total);
    }

    /**
     * 默认返回失败方法
     */
    public static BaseResult fail() {
        return BaseResult.createResult(STATUS_FALL, "失败", null,0);
    }

    /**
     * 返回失败带消息
     */
    public static BaseResult fail(String message) {
        return BaseResult.createResult(STATUS_FALL, message, null,0);
    }

    /**
     * 返回失败带消息和数据
     */
    public static BaseResult fail(String message, Object result) {
        return BaseResult.createResult(STATUS_FALL, message, result,0);
    }

}


