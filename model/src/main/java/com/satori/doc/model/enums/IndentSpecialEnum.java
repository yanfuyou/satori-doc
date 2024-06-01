package com.satori.doc.model.enums;

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
    HANG(2, "悬挂"),
    ;

    @JsonValue
    public final Integer value;
    public final String desc;
}
