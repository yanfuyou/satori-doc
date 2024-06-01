package com.satori.doc.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

/**
 * @author cat_y
 * 对齐方式
 */

@AllArgsConstructor
public enum AlignMethodEnum {
    LEFT(1, "左对齐"),
    CENTER(2, "居中对齐"),
    RIGHT(3, "右对齐"),
    ENDS(4, "两端对齐"),
    VARIANCE(5, "分散对齐"),

    ;

    @JsonValue
    public final Integer value;

    public final String desc;
}
