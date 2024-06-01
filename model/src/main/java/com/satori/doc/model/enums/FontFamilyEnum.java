package com.satori.doc.model.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

/**
 * 字体
 */

@AllArgsConstructor
public enum FontFamilyEnum {
    HEI_TI(1, "黑体"),
    SONG_TI(2, "宋体"),
    T_N_R(3, "Times New Roman"),
    ;

    @JsonValue
    public final Integer value;

    public final String desc;
}
