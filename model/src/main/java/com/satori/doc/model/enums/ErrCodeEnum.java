package com.satori.doc.model.enums;

import com.satori.doc.model.code.ICodeService;
import lombok.AllArgsConstructor;

/**
 * @author cat_y
 */
@AllArgsConstructor
public enum ErrCodeEnum implements ICodeService<Object> {
    REPEAT_NAME("50001", "名称重复", "%s名称重复"),
    DATA_DOES_NOT_EXIST("50002", "数据不存在", "%s数据不存在"),
    ;

    public final String code;

    public final String msg;

    public final String msgFormat;

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String desc() {
        return this.msg;
    }

    @Override
    public String msgFormat() {
        return this.msgFormat;
    }
}
