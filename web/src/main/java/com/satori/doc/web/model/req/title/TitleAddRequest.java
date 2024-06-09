package com.satori.doc.web.model.req.title;

import com.satori.doc.model.json.TitleConfiguration;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cat_y
 */

@Schema(description = "标题")
@Data
public class TitleAddRequest implements Serializable {

    @Schema(description = "文档ID")
    @NotNull(message = "文档id不能为空")
    private Long docId;

    @Schema(description = "标题内容")
    @NotBlank(message = "标题内容不能为空")
    private String content;

    @Schema(description = "样式")
    private TitleConfiguration configuration;

    @Schema(description = "前序标题ID")
    private Long followId;
}
