package com.satori.doc.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

/**
 * 字体样式
 */
@AllArgsConstructor
public enum FontStyleEnum {
    NORMAL(1, "常规"),
    BOLD(2, "加粗"),
    INCLINE(3, "倾斜"),
    ;

    @JsonValue
    public final Integer value;

    public final String desc;

}
