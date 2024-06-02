package com.satori.doc.core.factory;

import lombok.Data;
import lombok.Getter;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 * @author cat_y
 */

@Data
public class DocBeanFactory {

    @Getter
    private static XWPFDocument xwpfDocument = new XWPFDocument();

}
