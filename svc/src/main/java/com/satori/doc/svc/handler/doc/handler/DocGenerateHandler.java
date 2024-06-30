package com.satori.doc.svc.handler.doc.handler;

import com.satori.doc.model.Paragraph;
import com.satori.doc.model.doc.Doc;
import com.satori.doc.svc.dal.po.DocPO;
import com.satori.doc.svc.dal.po.ParagraphPO;

import java.util.List;
import java.util.Objects;

/**
 * @author cat_y
 */
public class DocGenerateHandler {

    public static Doc assemble(DocPO po, List<ParagraphPO> paragraphs) {
        Doc doc = new Doc();
        doc.setId(po.getId());
        doc.setName(po.getName());
        doc.setType(po.getType());
        doc.setParagraphs(assembleParagraph(paragraphs));
        return doc;
    }

    private static List<Paragraph> assembleParagraph(List<ParagraphPO> paragraphList) {
        List<Paragraph> roots = paragraphList.stream()
                .filter(p -> Objects.equals(0L, p.getParentId()))
                .map(po -> Paragraph.builder()
                        .id(po.getId())
                        .docId(po.getDocId())
                        .content(po.getContent())
                        .configuration(po.getConfiguration())
                        .isTitle(po.getIsTitle())
                        .hidden(po.getHidden())
                        .parentId(po.getParentId())
                        .build())
                .toList();
        roots.forEach(root -> buildChildren(root, paragraphList));
        return roots;
    }

    private static void buildChildren(Paragraph root, List<ParagraphPO> paragraphList) {
        List<ParagraphPO> children = paragraphList.stream()
                .filter(child -> root.getId().equals(child.getParentId()))
                .toList();
        if (!children.isEmpty()) {
            root.setChildren(children.stream()
                    .map(child -> Paragraph.builder()
                            .id(child.getId())
                            .docId(child.getDocId())
                            .content(child.getContent())
                            .configuration(child.getConfiguration())
                            .isTitle(child.getIsTitle())
                            .hidden(child.getHidden())
                            .parentId(child.getParentId())
                            .build())
                    .toList());
            for (Paragraph child : root.getChildren()) {
                buildChildren(child, paragraphList);
            }
        }
    }
}
