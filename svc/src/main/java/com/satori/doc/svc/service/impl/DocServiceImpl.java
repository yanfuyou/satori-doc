package com.satori.doc.svc.service.impl;

import com.satori.doc.svc.dal.po.DocPO;
import com.satori.doc.svc.dal.mapper.DocMapper;
import com.satori.doc.svc.service.IDocService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文档 服务实现类
 * </p>
 *
 * @author cat_y
 * @since 2024-05-31
 */
@Service
public class DocServiceImpl extends ServiceImpl<DocMapper, DocPO> implements IDocService {

}
