package com.satori.doc.core.dto;

import com.satori.doc.model.json.ParagraphConfiguration;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 段落
 * </p>
 *
 * @author cat_y
 * @since 2024-06-01
 */
@Getter
@Setter
public class ParagraphDTO implements Serializable {

    /**
     * 所属文档
     */
    private Long docId;

    /**
     * 所属标题
     */
    private Long titleId;

    /**
     * 段落内容
     */
    private String content;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 配置,样式等
     */
    private ParagraphConfiguration configuration;
}
