package com.satori.doc.core.handler;

import com.satori.doc.core.model.Paragraph;
import com.satori.doc.core.model.Title;
import com.satori.doc.model.json.BaseConfiguration;
import lombok.Data;

import java.util.Objects;

/**
 * @author cat_y
 */

@Data
public class ParagraphContext {

    /**
     * 标题
     */
    private Title title;

    /**
     * 段落
     */
    private Paragraph paragraph;

    /**
     * 内容
     */
    private String content;

    /**
     * 基础配置
     */
    private BaseConfiguration baseConfiguration;

    /**
     * 标题段落
     */
    private Boolean titleParagraph;

    public static ParagraphContext of(Title title, Paragraph paragraph) {
        ParagraphContext context = new ParagraphContext();
        if (Objects.nonNull(title)) {
            context.setTitle(title);
            context.setContent(title.getContent());
            context.setTitleParagraph(true);
            context.setBaseConfiguration(title.getConfiguration());
        }
        if (Objects.nonNull(context.getParagraph())) {
            context.setParagraph(paragraph);
            context.setContent(context.getContent());
            context.setTitleParagraph(false);
            context.setBaseConfiguration(paragraph.getConfiguration());
        }
        return context;
    }

}
