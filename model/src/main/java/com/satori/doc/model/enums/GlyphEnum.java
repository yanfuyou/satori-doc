package com.satori.doc.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
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

    FIRST(1, "初号", 42.0),
    TRUMPET(2, "小初号", 36.0),
    NUMBER_ONE(3, "一号", 26.0),
    TRUMPET_NUMBER_ONE(4, "小一", 24.0),

    ;
    @EnumValue
    @JsonValue
    public final Integer value;

    public final String desc;

    public final Double pixel;
}
