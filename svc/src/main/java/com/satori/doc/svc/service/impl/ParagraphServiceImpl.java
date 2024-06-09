package com.satori.doc.svc.service.impl;

import com.satori.doc.svc.dal.po.ParagraphPO;
import com.satori.doc.svc.dal.mapper.ParagraphMapper;
import com.satori.doc.svc.dto.req.paragraph.ParagraphReqDTO;
import com.satori.doc.svc.service.IParagraphService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 段落 服务实现类
 * </p>
 *
 * @author cat_y
 * @since 2024-06-01
 */
@Service
public class ParagraphServiceImpl extends ServiceImpl<ParagraphMapper, ParagraphPO> implements IParagraphService {

    @Override
    public Long add(ParagraphReqDTO req) {

        ParagraphPO paragraph = new ParagraphPO();
        BeanUtils.copyProperties(req, paragraph);
        this.save(paragraph);
        return paragraph.getId();
    }
}
