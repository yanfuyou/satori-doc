package com.satori.doc.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

/**
 * @author cat_y
 * 缩进
 */

@AllArgsConstructor
public enum IndentSpecialEnum {
    NONE(1, "无"),
    OEN_LINE(2, "首行"),
    HANG(3, "悬挂"),
    ;
    @EnumValue
    @JsonValue
    public final Integer value;
    public final String desc;
}
