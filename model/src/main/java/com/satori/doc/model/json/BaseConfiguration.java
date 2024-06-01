package com.satori.doc.model.json;

import com.satori.doc.model.enums.IndentSpecialEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.IdentityHashMap;

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



}
