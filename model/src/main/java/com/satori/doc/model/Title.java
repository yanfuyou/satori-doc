package com.satori.doc.model;

import com.satori.doc.model.json.TitleConfiguration;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author cat_y
 */
@Data
public class Title implements Serializable {
    private Long id;

    private Long docId;

    private Long followId;

    private String content;

    private TitleConfiguration configuration;

    private List<Paragraph> paragraphs;

}
