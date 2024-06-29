package com.satori.doc.svc.handler.doc.context;

import com.satori.doc.model.doc.Doc;
import com.satori.doc.svc.dal.po.DocPO;
import com.satori.doc.svc.dal.po.ParagraphPO;
import com.satori.doc.svc.dal.po.TitlePO;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author cat_y
 */

@Data
@Component
public class DocGenerateContext {
    /**
     * 文档
     */
    private Doc doc;

    public static DocGenerateContext of(Doc doc) {
        DocGenerateContext context = new DocGenerateContext();
        context.setDoc(doc);
        return context;
    }
}
