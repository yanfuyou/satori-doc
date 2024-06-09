package com.satori.doc.web.model.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cat_y
 */

@Data
public class TitleResponse implements Serializable {
    @Schema(description = "标题ID")
    private Long id;
}
