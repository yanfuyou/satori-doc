package com.satori.doc.core.handler;

import com.satori.doc.core.model.Doc;
import com.satori.doc.core.model.Paragraph;
import com.satori.doc.core.model.SavePath;
import com.satori.doc.core.model.Title;
import com.satori.doc.core.factory.DocBeanFactory;
import com.satori.doc.model.enums.GlyphEnum;
import com.satori.doc.model.json.*;
import lombok.NonNull;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;


/**
 * @author cat_y
 */
public class DocHandler {

    /**
     * 文档保存路径
     */
    static final String resourcesDir = System.getProperty("user.dir") + "/core/src/main/resources/doc/";


    /**
     * 文档生成
     */
    public static SavePath generator(Doc doc) {
        XWPFDocument document = new XWPFDocument();
        doc.getTitles().forEach(t -> {
            titleGenerator(document, t);
            t.getParagraphs().forEach(p -> {
                paragraphGenerator(document, p);
            });
        });
        // 保存
        final String savePath = resourcesDir + doc.getSaveName();
        File file = new File(savePath);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            boolean created = parentFile.mkdirs();
            if (!created) {
                throw new RuntimeException("file can't be created");
            }
        }

        try (FileOutputStream outputStream = new FileOutputStream(file)) {
            document.write(outputStream);
            document.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SavePath result = new SavePath();
        result.setLocalPath(savePath);
        return result;
    }

    /**
     * 标题
     *
     * @param title 标题对象
     */
    public static void titleGenerator(XWPFDocument document, Title title) {
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
        switch (config.getAlign()) {
            case LEFT -> paragraph.setAlignment(ParagraphAlignment.LEFT);
            case CENTER -> paragraph.setAlignment(ParagraphAlignment.CENTER);
            case RIGHT -> paragraph.setAlignment(ParagraphAlignment.RIGHT);
            case ENDS -> paragraph.setAlignment(ParagraphAlignment.END);
            case VARIANCE -> paragraph.setAlignment(ParagraphAlignment.DISTRIBUTE);
        }
    }

    /**
     * 段落
     *
     * @param paragraph 段落配置
     */
    public static void paragraphGenerator(XWPFDocument document, Paragraph paragraph) {
        ParagraphConfiguration config = paragraph.getConfiguration();
        StringBuilder content = new StringBuilder(paragraph.getContent());
        XWPFParagraph docParagraph = document.createParagraph();
        XWPFRun run = docParagraph.createRun();

        FontConfiguration fontConfiguration = config.getFontConfiguration();
        GlyphEnum glyph = fontConfiguration.getGlyph();
        IndentConfiguration indentConfiguration = config.getIndentConfiguration();
        // TODO:yfy 缩进设置有问题
        switch (indentConfiguration.getSpecial()) {
            case OEN_LINE -> {
                int num = indentConfiguration.getIndentVal().intValue();
                for (int i = 0; i < num; i++) {
                    content.insert(0, " ");
                }
            }
            case HANG ->
                    docParagraph.setIndentationHanging(charsToPoints(indentConfiguration.getIndentVal().intValue(), glyph.pixel.intValue()));
        }
        run.setText(content.toString());
    }

    private static int charsToPoints(int numChars, int fontSize) {
        // 假设每个字符的宽度约为字体大小的一半（即 0.5 * 字体大小）
        return (int) (numChars * fontSize * 0.5);
    }
}
