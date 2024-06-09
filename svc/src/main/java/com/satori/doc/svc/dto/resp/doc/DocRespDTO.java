package com.satori.doc.svc.dto.resp.doc;

import com.satori.doc.model.Title;
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
    private Long docId;

    /**
     * 文档内容
     */
    private String name;

    /**
     * 标题
     */
    private List<Title> titles;
}
