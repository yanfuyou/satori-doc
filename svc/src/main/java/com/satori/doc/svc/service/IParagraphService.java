package com.satori.doc.svc.service;

import com.satori.doc.svc.dal.po.ParagraphPO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.satori.doc.svc.dto.req.paragraph.ParagraphReqDTO;

/**
 * <p>
 * 段落 服务类
 * </p>
 *
 * @author cat_y
 * @since 2024-06-01
 */
public interface IParagraphService extends IService<ParagraphPO> {

    Long add(ParagraphReqDTO req);
}
