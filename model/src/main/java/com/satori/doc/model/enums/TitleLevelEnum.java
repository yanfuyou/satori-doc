package com.satori.doc.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

/**
 * 标题级别
 */
@AllArgsConstructor
public enum TitleLevelEnum {
    LEVEL_1(1, "一级"),
    LEVEL_2(2, "二级"),
    LEVEL_3(3, "三级"),
    LEVEL_4(4, "四级"),
    ;
    @EnumValue
    @JsonValue
    public final Integer value;

    public final String desc;
}
