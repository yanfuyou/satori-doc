package com.satori.doc.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

/**
 * @author cat_y
 */
@AllArgsConstructor
public enum DocTypeEnum {

    XLSX(1, "wordXlsx", ".docx");

    @JsonValue
    @EnumValue
    public final Integer value;

    public final String name;

    public final String suffix;
}
