package com.satori.doc.svc.handler.doc.context;

import com.satori.doc.model.doc.Doc;
import lombok.Data;
import org.springframework.stereotype.Component;

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
