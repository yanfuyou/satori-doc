package com.satori.doc.model.vo;

import com.satori.doc.model.code.ReplayCode;

import java.io.Serializable;

/**
 * @author cat_y
 * 标准返回对象
 */
public class ResultVO<T> implements Serializable {

    /**
     * 业务状态码
     */
    public final String code;

    /**
     * 业务信息
     */
    public final String msg;

    /**
     * 是否成功
     */
    public final Boolean success;

    /**
     * 数据体
     */
    public final T data;

    public ResultVO(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.success = ReplayCode.SUCCESS.code.equals(code);
        this.data = data;
    }

    public ResultVO(String code, String msg) {
        this(code, msg, null);
    }

    /**
     * 无数据成功
     */
    public static <T> ResultVO<T> success() {
        return new ResultVO<>(ReplayCode.SUCCESS.code, ReplayCode.SUCCESS.desc);
    }

    /**
     * 有数据成功
     */
    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(ReplayCode.SUCCESS.code, ReplayCode.SUCCESS.desc, data);
    }

    /**
     * 无数据失败
     * 使用系统错误码
     */
    public static <T> ResultVO<T> fail() {
        return new ResultVO<>(ReplayCode.FAIL.code, ReplayCode.FAIL.desc);
    }

    /**
     * 无数据失败
     * 自定义错误码
     */
    public static <T> ResultVO<T> fail(String code, String msg) {
        return new ResultVO<>(code, msg);
    }

    /**
     * 有数据失败
     * 使用自定义错误码
     */
    public static <T> ResultVO<T> fail(T data) {
        return new ResultVO<>(ReplayCode.FAIL.code, ReplayCode.FAIL.desc, data);
    }

    /**
     * 有数据失败
     * 使用自定义错误码
     */
    public static <T> ResultVO<T> fail(String code, String msg, T data) {
        return new ResultVO<>(code, msg, data);
    }

}
