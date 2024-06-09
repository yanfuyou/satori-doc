package com.satori.doc.svc.dto.req.paragraph;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.satori.doc.model.json.ParagraphConfiguration;
import lombok.Data;

/**
 * @author cat_y
 * @since 2024-06-01
 */
@Data
public class ParagraphReqDTO {

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
     * 配置,样式等
     */
    private ParagraphConfiguration configuration;

    /**
     * 前序id
     */
    private Long followId;
}
