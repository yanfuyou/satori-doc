package com.satori.doc.model.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author cat_y
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class IdAutoOptionalPO extends IdAutoPO {
    @TableField(value = "creator_id", fill = FieldFill.INSERT)
    private Long creatorId;
    @TableField(value = "creator", fill = FieldFill.INSERT)
    private String creator;
    @TableField(value = "modifier_id", fill = FieldFill.UPDATE)
    private Long modifierId;
}
