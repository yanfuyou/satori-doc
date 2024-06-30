package com.satori.doc.svc.dal.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.satori.doc.model.json.ParagraphConfiguration;
import com.satori.doc.model.po.IdAutoOptionalPO;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.satori.doc.model.po.IdAutoPO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
@TableName(value = "paragraph", autoResultMap = true)
public class ParagraphPO extends IdAutoPO {

    private static final long serialVersionUID = 1L;

    /**
     * 所属文档
     */
    private Long docId;

    /**
     * 段落内容
     */
    private String content;

    /**
     * 配置,样式等
     */
    @TableField(value = "configuration", typeHandler = JacksonTypeHandler.class)
    private ParagraphConfiguration configuration;

    /**
     * 标题?
     */
    private Boolean isTitle;

    /**
     * 隐藏?
     */
    private Boolean hidden;

    /**
     * 父级ID
     */
    private Long parentId;
}
