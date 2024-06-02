package com.satori.doc.model.json;

import com.satori.doc.model.enums.AlignMethodEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cat_y
 * 公共配置
 */

@Data
public class BaseConfiguration implements Serializable {

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
