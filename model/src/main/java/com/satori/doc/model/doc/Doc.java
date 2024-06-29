package com.satori.doc.model.doc;

import com.satori.doc.model.Paragraph;
import com.satori.doc.model.enums.DocTypeEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author cat_y
 * @date 2024/06/29
 * @description 文档
 */

@Data
public class Doc implements Serializable {
    /**
     * 文档id
     */
    private Long id;
    /**
     * 文档名
     */
    private String name;
    /**
     * 文档类型
     */
    private DocTypeEnum type;
    /**
     * 段落
     */
    private List<Paragraph> paragraphs;
}
