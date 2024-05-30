package com.satori.doc.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自增id
 *
 * @author cat_y
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class IdAutoPO extends BasePO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
}
