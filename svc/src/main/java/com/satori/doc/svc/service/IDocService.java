package com.satori.doc.svc.service;

import com.satori.doc.model.enums.DocTypeEnum;
import com.satori.doc.svc.dal.po.DocPO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.satori.doc.svc.dto.resp.doc.DocListRespDTO;
import com.satori.doc.svc.dto.resp.doc.DocRespDTO;

import java.util.List;

/**
 * <p>
 * 文档 服务类
 * </p>
 *
 * @author cat_y
 * @since 2024-05-31
 */
public interface IDocService extends IService<DocPO> {

    Long save(String name, DocTypeEnum type);

    DocRespDTO get(Long id);

    String create(Long id);

    List<DocListRespDTO> listAll();
}
