package com.satori.doc.model.json;

import com.satori.doc.model.enums.FontFamilyEnum;
import com.satori.doc.model.enums.FontStyleEnum;
import com.satori.doc.model.enums.GlyphEnum;
import lombok.Data;

/**
 * @author cat_y
 * 字体配置
 */

@Data
public class FontConfiguration {
    /**
     * 字体
     */
    private FontFamilyEnum fontFamily;

    /**
     * 字号
     */
    private GlyphEnum glyph;

    /**
     * 样式
     */
    private FontStyleEnum fontStyle;


}
