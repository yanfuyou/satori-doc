package com.satori.doc.svc.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.satori.doc.model.enums.DocTypeEnum;
import com.satori.doc.model.enums.ErrCodeEnum;
import com.satori.doc.svc.dal.po.DocPO;
import com.satori.doc.svc.dal.mapper.DocMapper;
import com.satori.doc.svc.dal.po.ParagraphPO;
import com.satori.doc.svc.dal.po.TitlePO;
import com.satori.doc.svc.dto.resp.doc.DocRespDTO;
import com.satori.doc.svc.handler.doc.context.DocGenerateContext;
import com.satori.doc.svc.handler.doc.handler.DocGenerateHandler;
import com.satori.doc.svc.service.IDocService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.satori.doc.svc.service.IParagraphService;
import com.satori.doc.svc.service.ITitleService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 文档 服务实现类
 * </p>
 *
 * @author cat_y
 * @since 2024-05-31
 */

@RequiredArgsConstructor
@Service
public class DocServiceImpl extends ServiceImpl<DocMapper, DocPO> implements IDocService {

    private final ITitleService titleService;
    private final IParagraphService paragraphService;

    @Resource
    private DocGenerateContext docGenerateContext;

    @Override
    public Long save(String name, DocTypeEnum type) {
        DocPO doc = new DocPO();
        doc.setName(name);
        doc.setType(type);
        try {
            this.save(doc);
        } catch (DuplicateKeyException e) {
            throw ErrCodeEnum.REPEAT_NAME.buildEx("文档");
        }
        return doc.getId();
    }

    @Override
    public DocRespDTO get(Long id) {
        DocPO doc = this.getById(id);
        if (Objects.isNull(doc)) {
            throw ErrCodeEnum.DATA_DOES_NOT_EXIST.buildEx("文档");
        }
        List<TitlePO> titleList = titleService.list(Wrappers.lambdaQuery(TitlePO.class)
                .eq(TitlePO::getDocId, id));
        List<ParagraphPO> paragraphList = paragraphService.list(Wrappers.lambdaQuery(ParagraphPO.class)
                .eq(ParagraphPO::getDocId, id));
        DocGenerateContext context = docGenerateContext.of(doc, titleList, paragraphList);
        return DocGenerateHandler.assemble(context);
    }


}
