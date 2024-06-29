package com.satori.doc.model;

import com.satori.doc.model.json.ParagraphConfiguration;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author cat_y
 */

@Data
public class Paragraph implements Serializable {
    /**
     * 段落
     */
    private Long id;
    /**
     * 文档id
     */
    private Long docId;
    /**
     * 内容
     */
    private String content;
    /**
     * 样式配置
     */
    private ParagraphConfiguration configuration;
    /**
     * 是否是标题
     */
    private Boolean isTitle;
    /**
     * 是否需要隐藏
     */
    private Boolean hidden;
    /**
     * 父级段落id
     */
    private Long parentId;
    /**
     * 子段落
     */
    private List<Paragraph> children;
}
