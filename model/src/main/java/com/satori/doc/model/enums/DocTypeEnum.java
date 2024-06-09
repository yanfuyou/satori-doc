package com.satori.doc.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

/**
 * @author cat_y
 */
@AllArgsConstructor
public enum DocTypeEnum {

    XLSX(1, "wordXlsx", ".xlsx");

    @JsonValue
    @EnumValue
    public final Integer value;

    private final String name;

    private final String suffix;
}
