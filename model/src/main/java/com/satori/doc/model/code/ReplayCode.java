package com.satori.doc.model.code;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author cat_y
 */

@Accessors(chain = true)
@AllArgsConstructor
public enum ReplayCode implements ICodeService<Object> {
    SUCCESS("00000", "成功", null),
    FAIL("50000", "成功", null),

    ;

    public final String code;

    public final String desc;

    public final String msgFormat;

    @Override
    public String code() {
        return null;
    }

    @Override
    public String desc() {
        return null;
    }

    @Override
    public String msgFormat() {
        return null;
    }
}
