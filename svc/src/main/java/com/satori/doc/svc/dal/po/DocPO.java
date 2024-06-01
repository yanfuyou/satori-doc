package com.satori.doc.svc.dal.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.satori.doc.model.document.DocConfiguration;
import com.satori.doc.model.po.IdAutoOptionalPO;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 文档
 * </p>
 *
 * @author cat_y
 * @since 2024-05-31
 */
@Getter
@Setter
@TableName(value = "doc", autoResultMap = true)
public class DocPO extends IdAutoOptionalPO {

    private static final long serialVersionUID = 1L;

    /**
     * 文档名称
     */
    private String name;

    /**
     * 文档类型
     */
    private Integer type;

    /**
     * 配置,样式等
     */
    @TableField(value = "configuration", typeHandler = JacksonTypeHandler.class)
    private DocConfiguration configuration;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;
}
