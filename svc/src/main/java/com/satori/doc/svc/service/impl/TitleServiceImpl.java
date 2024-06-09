package com.satori.doc.svc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.satori.doc.svc.dal.mapper.TitleMapper;
import com.satori.doc.svc.dal.po.TitlePO;
import com.satori.doc.svc.dto.req.title.TitleAddReqDTO;
import com.satori.doc.svc.service.ITitleService;
import org.springframework.beans.BeanUtils;
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

    @Override
    public Long add(TitleAddReqDTO req) {
        TitlePO title = new TitlePO();
        BeanUtils.copyProperties(req, title);
        this.save(title);
        return title.getId();
    }
}
