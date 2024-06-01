package com.satori.doc.svc.dal.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.satori.doc.model.po.IdAutoOptionalPO;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

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
@TableName("title")
public class TitlePO extends IdAutoOptionalPO {

    private static final long serialVersionUID = 1L;

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
    @TableField(value = "configuration", typeHandler = JacksonTypeHandler.class)
    private String configuration;
}
