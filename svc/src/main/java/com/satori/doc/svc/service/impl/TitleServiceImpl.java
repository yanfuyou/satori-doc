package com.satori.doc.svc.service.impl;

import com.satori.doc.svc.dal.po.TitlePO;
import com.satori.doc.svc.dal.mapper.TitleMapper;
import com.satori.doc.svc.service.ITitleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文档标题 服务实现类
 * </p>
 *
 * @author cat_y
 * @since 2024-06-01
 */
@Service
public class TitleServiceImpl extends ServiceImpl<TitleMapper, TitlePO> implements ITitleService {

}
