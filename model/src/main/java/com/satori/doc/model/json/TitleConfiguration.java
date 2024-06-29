package com.satori.doc.model.json;

import com.satori.doc.model.enums.TitleLevelEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author cat_y
 * 标题配置
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class TitleConfiguration extends ParagraphConfiguration {

    /**
     * 标题级别
     */
    private TitleLevelEnum level;
}
