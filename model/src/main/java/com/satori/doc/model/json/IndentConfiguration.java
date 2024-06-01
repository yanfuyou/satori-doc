package com.satori.doc.model.json;

import com.satori.doc.model.enums.IndentSpecialEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author cat_y
 * 缩进配置
 */

@Data
public class IndentConfiguration implements Serializable {
    /**
     * 特殊
     */
    private IndentSpecialEnum special;

    /**
     * 缩进值
     */
    private BigDecimal indentVal;
}
