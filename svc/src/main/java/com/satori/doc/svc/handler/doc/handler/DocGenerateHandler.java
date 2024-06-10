package com.satori.doc.svc.handler.doc.handler;

import com.baomidou.mybatisplus.annotation.TableField;
import com.satori.doc.model.Paragraph;
import com.satori.doc.model.Title;
import com.satori.doc.model.enums.ErrCodeEnum;
import com.satori.doc.svc.dal.po.DocPO;
import com.satori.doc.svc.dal.po.ParagraphPO;
import com.satori.doc.svc.dal.po.TitlePO;
import com.satori.doc.svc.dto.resp.doc.DocRespDTO;
import com.satori.doc.svc.handler.doc.context.DocGenerateContext;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author cat_y
 */
public class DocGenerateHandler {

    public static DocRespDTO assemble(DocGenerateContext context) {
        DocRespDTO res = new DocRespDTO();
        DocPO doc = context.getDoc();
        res.setDocId(doc.getId());
        res.setName(doc.getName());
        res.setType(doc.getType());
        List<TitlePO> titlePOS = context.getTitleList();
        List<ParagraphPO> paragraphPOS = context.getParagraphList();
        if (CollectionUtils.isEmpty(titlePOS)) {
            return res;
        }
        List<Title> titles = new ArrayList<>();

        TitlePO first = null;
        for (TitlePO titlePO : titlePOS) {
            Long tFollowId = titlePO.getFollowId();
            boolean present = titlePOS.stream().anyMatch(title -> tFollowId.equals(title.getId()));
            if (!present) {
                first = titlePO;
                break;
            }
        }
        if (Objects.isNull(first)) {
            throw ErrCodeEnum.DATA_DOES_NOT_EXIST.buildEx("标题");
        }
        Title title = new Title();
        title.setId(first.getId());
        title.setContent(first.getContent());
        title.setConfiguration(first.getConfiguration());
        titles.add(title);
        assembleTitle(title, titlePOS, paragraphPOS, titles);
        res.setTitles(titles);
        return res;
    }

    private static void assembleTitle(Title cur, List<TitlePO> titlePOS, List<ParagraphPO> paragraphPOS, List<Title> result) {
        List<Paragraph> paragraphs = paragraphPOS.stream().filter(pa -> pa.getTitleId().equals(cur.getId()))
                .map(pa -> {
                    Paragraph paragraph = new Paragraph();
                    BeanUtils.copyProperties(pa, paragraph);
                    return paragraph;
                })
                .toList();
        cur.setParagraphs(paragraphs);
        TitlePO next = titlePOS.stream().filter(title -> title.getFollowId().equals(cur.getId())).findFirst().orElse(null);
        if (Objects.isNull(next)) {
            return;
        }
        Title title = new Title();
        BeanUtils.copyProperties(next, title);
        result.add(title);
        assembleTitle(title, titlePOS, paragraphPOS, result);
    }

}
