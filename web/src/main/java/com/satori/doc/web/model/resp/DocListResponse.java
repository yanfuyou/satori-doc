package com.satori.doc.web.model.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author cat_y
 */

@Schema(description = "文档列表")
@Data
public class DocListResponse {

    @Schema(description = "文档id")
    private Long id;

    @Schema(description = "文档名")
    private String name;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
