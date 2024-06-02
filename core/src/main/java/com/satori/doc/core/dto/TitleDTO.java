package com.satori.doc.core.dto;

import com.satori.doc.model.json.TitleConfiguration;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 文档标题
 * </p>
 *
 * @author cat_y
 * @since 2024-06-01
 */
@Getter
@Setter
public class TitleDTO implements Serializable {

    /**
     * 文档ID
     */
    private Long docId;

    /**
     * 标题内容
     */
    private String content;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 配置,样式等
     */

    private TitleConfiguration configuration;
}
