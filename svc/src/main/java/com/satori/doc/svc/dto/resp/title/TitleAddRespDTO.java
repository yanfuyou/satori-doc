package com.satori.doc.svc.dto.resp.title;

import com.satori.doc.model.json.TitleConfiguration;
import lombok.Data;

/**
 * @author cat_y
 */

@Data
public class TitleAddRespDTO {

    /**
     * 文档ID
     */
    private Long docId;

    /**
     * 标题内容
     */
    private String content;

    /**
     * 样式
     */
    private TitleConfiguration configuration;

    /**
     * 前序标题ID
     */
    private Long followId;
}
