package com.satori.doc.core.handler;

import com.satori.doc.core.dto.ParagraphDTO;
import com.satori.doc.core.dto.TitleDTO;
import com.satori.doc.core.factory.DocBeanFactory;
import com.satori.doc.model.enums.AlignMethodEnum;
import com.satori.doc.model.json.BaseConfiguration;
import com.satori.doc.model.json.FontConfiguration;
import com.satori.doc.model.json.ParagraphConfiguration;
import com.satori.doc.model.json.TitleConfiguration;
import lombok.NonNull;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.IOException;
import java.util.Objects;


/**
 * @author cat_y
 */
public class DocHandler {
    @NonNull
    static XWPFDocument document = DocBeanFactory.getXwpfDocument();


    /**
     * 统一的转换处理
     * 内容都是段落,只是样式不同
     *
     * @param context 上下文
     * @return doc
     */
    public static XWPFDocument commonGenerator(ParagraphContext context) {
        BaseConfiguration configuration = context.getBaseConfiguration();
        FontConfiguration fontConfiguration = configuration.getFontConfiguration();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(context.getContent());
        switch (configuration.getAlign()) {
            case LEFT -> paragraph.setAlignment(ParagraphAlignment.LEFT);
            case CENTER -> paragraph.setAlignment(ParagraphAlignment.CENTER);
            case RIGHT -> paragraph.setAlignment(ParagraphAlignment.RIGHT);
            case ENDS -> paragraph.setAlignment(ParagraphAlignment.END);
            case VARIANCE -> paragraph.setAlignment(ParagraphAlignment.DISTRIBUTE);
        }
        switch (fontConfiguration.getFontStyle()) {
            case BOLD -> run.setBold(true);
            case INCLINE -> run.setItalic(true);
        }
        run.setFontFamily(fontConfiguration.getFontFamily().desc);
        run.setFontSize(fontConfiguration.getGlyph().pixel);

        return document;
    }

    /**
     * 标题
     *
     * @param title 标题对象
     * @return 文档
     */
    public static XWPFDocument titleGenerator(TitleDTO title) {
        XWPFParagraph paragraph = document.createParagraph();
        String content = title.getContent();
        TitleConfiguration config = title.getConfiguration();
        XWPFRun run = paragraph.createRun();
        run.setText(content);
        FontConfiguration fontConfiguration = config.getFontConfiguration();
        switch (fontConfiguration.getFontStyle()) {
            case BOLD -> run.setBold(true);
            case INCLINE -> run.setItalic(true);
        }

        return document;
    }

    /**
     * 段落
     *
     * @param paragraph 段落配置
     * @return doc
     */
    public static XWPFDocument paragraphGenerator(ParagraphDTO paragraph) {
        ParagraphConfiguration config = paragraph.getConfiguration();
        String content = paragraph.getContent();
        XWPFParagraph docParagraph = document.createParagraph();
        XWPFRun run = docParagraph.createRun();
        run.setText(content);
        return document;
    }
}
