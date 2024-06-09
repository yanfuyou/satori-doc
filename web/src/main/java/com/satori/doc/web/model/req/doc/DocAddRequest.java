package com.satori.doc.web.model.req.doc;

import com.satori.doc.model.enums.DocTypeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cat_y
 */

@Schema(description = "文档")
@Data
public class DocAddRequest implements Serializable {

    @Schema(description = "文档名称")
    @NotBlank(message = "文档名不能为空")
    private String name;

    @Schema(description = "类型;1:xlsx")
    @NotNull(message = "类型不能为空")
    private DocTypeEnum type = DocTypeEnum.XLSX;

}
