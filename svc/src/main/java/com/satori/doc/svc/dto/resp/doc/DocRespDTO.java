package com.satori.doc.svc.dto.resp.doc;

import com.satori.doc.model.Paragraph;
import com.satori.doc.model.Title;
import com.satori.doc.model.enums.DocTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * @author cat_y
 */

@Data
public class DocRespDTO {
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
