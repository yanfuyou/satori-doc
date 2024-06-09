package com.satori.doc.model;

import com.satori.doc.model.json.ParagraphConfiguration;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cat_y
 */

@Data
public class Paragraph implements Serializable {

    private Long id;

    private Long docId;

    private Long titleId;

    private Long followId;

    private String content;

    private ParagraphConfiguration configuration;
}
