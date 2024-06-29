package com.satori.doc.core.model;

import com.satori.doc.model.enums.DocTypeEnum;
import com.satori.doc.model.json.DocConfiguration;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 文档
 * </p>
 *
 * @author cat_y
 * @since 2024-05-31
 */
@Data
public class Doc implements Serializable {

    /**
     * 文档名称
     */
    private String name;

    /**
     * 文档类型
     */
    private DocTypeEnum type;

    /**
     * 文档标题
     */
    private List<Title> titles;

    /**
     * 拼接文件后缀
     */
    public String getSaveName() {
        return this.name.trim() + this.type.suffix;
    }
}
