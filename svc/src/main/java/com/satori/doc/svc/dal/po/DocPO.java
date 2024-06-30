package com.satori.doc.svc.dal.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.satori.doc.model.enums.DocTypeEnum;
import com.satori.doc.model.po.IdAutoOptionalPO;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 文档
 * </p>
 *
 * @author cat_y
 * @since 2024-05-31
 */
@Getter
@Setter
@TableName(value = "doc", autoResultMap = true)
public class DocPO extends IdAutoOptionalPO {

    private static final long serialVersionUID = 1L;

    /**
     * 文档名称
     */
    private String name;

    /**
     * 文档类型
     */
    private DocTypeEnum type;

    /**
     * 本地路径
     */
    private String localPath;

    /**
     * 远程路径
     */
    private String originPath;
}
