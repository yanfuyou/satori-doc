package com.satori.doc.svc.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.satori.doc.common.util.bean.CopyUtils;
import com.satori.doc.core.handler.DocHandler;
import com.satori.doc.core.model.SavePath;
import com.satori.doc.model.doc.Doc;
import com.satori.doc.model.enums.DocTypeEnum;
import com.satori.doc.model.enums.ErrCodeEnum;
import com.satori.doc.svc.dal.mapper.DocMapper;
import com.satori.doc.svc.dal.po.DocPO;
import com.satori.doc.svc.dal.po.ParagraphPO;
import com.satori.doc.svc.dto.resp.doc.DocListRespDTO;
import com.satori.doc.svc.dto.resp.doc.DocRespDTO;
import com.satori.doc.svc.handler.doc.handler.DocGenerateHandler;
import com.satori.doc.svc.service.IDocService;
import com.satori.doc.svc.service.IParagraphService;
import com.satori.doc.svc.service.ITitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<ParagraphPO> paragraphList = paragraphService.list(Wrappers.lambdaQuery(ParagraphPO.class)
                .eq(ParagraphPO::getDocId, id));
        com.satori.doc.model.doc.Doc docModel = DocGenerateHandler.assemble(doc, paragraphList);
        return CopyUtils.copyPropertiesPlus(docModel, DocRespDTO.class, null);
    }

    @Override
    public SavePath create(Long id) {
        DocRespDTO docResp = this.get(id);
        String jsonString = JSON.toJSONString(docResp);
        Doc doc = JSON.parseObject(jsonString, Doc.class);
        SavePath savePath = DocHandler.generator(doc);
        this.update(Wrappers.lambdaUpdate(DocPO.class)
                .set(Objects.nonNull(savePath.getLocalPath()), DocPO::getLocalPath, savePath.getLocalPath())
                .set(Objects.nonNull(savePath.getOriginPath()), DocPO::getOriginPath, savePath.getOriginPath())
                .eq(DocPO::getId, id));
        return savePath;
    }

    @Override
    public List<DocListRespDTO> listAll() {
        List<DocPO> list = this.list(Wrappers.lambdaQuery(DocPO.class)
                .eq(DocPO::getDeleted, false));
        List<DocListRespDTO> result = new ArrayList<>();
        list.forEach(doc -> {
            DocListRespDTO dto = new DocListRespDTO();
            BeanUtils.copyProperties(doc, dto);
            result.add(dto);
        });
        return result;
    }

    @Override
    public void delLogic(Long id) {
        this.update(Wrappers.lambdaUpdate(DocPO.class)
                .set(DocPO::getDeleted, true)
                .eq(DocPO::getId, id));
    }

    public static void main(String[] args) {
        Doc doc = new Doc();
        doc.setType(DocTypeEnum.XLSX);
        List<Doc> docs = new ArrayList<>();
        docs.add(doc);
        List<Doc> docs1 = CopyUtils.copyPropertitesList(docs, Doc.class, null);
        System.out.println(docs1);

    }
}
