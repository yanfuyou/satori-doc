package com.satori.doc.svc.dto;

import com.satori.doc.model.json.DocConfiguration;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
public class DocDTO implements Serializable {

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
    private DocConfiguration configuration;
}
