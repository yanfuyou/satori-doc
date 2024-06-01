package com.satori.doc.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author cat_y
 * 字号
 */
@AllArgsConstructor
public enum GlyphEnum {

    FIRST(1, "初号", null),
    TRUMPET(2, "小号", null),
    NUMBER_ONE(3, "一号", null),
    TRUMPET_NUMBER_ONE(4, "小一", null),

    ;

    @JsonValue
    public final Integer value;

    public final String desc;

    public final BigDecimal pixel;
}
