package com.satori.doc.svc.service;

import com.satori.doc.svc.dal.po.TitlePO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.satori.doc.svc.dto.req.title.TitleAddReqDTO;
import com.satori.doc.svc.dto.resp.title.TitleAddRespDTO;

/**
 * <p>
 * 文档标题 服务类
 * </p>
 *
 * @author cat_y
 * @since 2024-06-01
 */
public interface ITitleService extends IService<TitlePO> {

    Long add(TitleAddReqDTO req);
}
