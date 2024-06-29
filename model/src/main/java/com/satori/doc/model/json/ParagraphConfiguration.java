package com.satori.doc.model.json;

import com.satori.doc.model.enums.AlignMethodEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author cat_y
 * 段落配置
 */
@Data
public class ParagraphConfiguration implements Serializable {
    /**
     * 字体配置
     */
    private FontConfiguration fontConfiguration;

    /**
     * 缩进配置
     */
    private IndentConfiguration indentConfiguration;

    /**
     * 对齐方式
     */
    private AlignMethodEnum align;
}
