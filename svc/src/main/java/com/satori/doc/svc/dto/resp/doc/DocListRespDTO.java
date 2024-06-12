package com.satori.doc.svc.dto.resp.doc;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author cat_y
 */

@Data
public class DocListRespDTO {

    /**
     * 文档id
     */
    private Long id;

    /**
     * 文档名
     */
    private String name;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

}
