package com.satori.doc.svc.handler.doc.handler;

import com.baomidou.mybatisplus.annotation.TableField;
import com.satori.doc.model.Paragraph;
import com.satori.doc.model.Title;
import com.satori.doc.model.doc.Doc;
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

    public static Doc assemble(DocPO docPO, List<ParagraphPO> paragraphs) {
        Doc doc = new Doc();


        return doc;
    }

}
