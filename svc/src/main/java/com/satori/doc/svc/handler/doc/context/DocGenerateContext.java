package com.satori.doc.svc.handler.doc.context;

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


    private DocPO doc;

    private List<TitlePO> titleList;

    private List<ParagraphPO> paragraphList;

    public DocGenerateContext of(DocPO doc, List<TitlePO> titleList, List<ParagraphPO> paragraphList) {
        DocGenerateContext context = new DocGenerateContext();
        context.setDoc(doc);
        context.setTitleList(titleList);
        context.setParagraphList(paragraphList);
        return context;
    }
}
