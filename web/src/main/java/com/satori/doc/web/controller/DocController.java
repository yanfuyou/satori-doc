package com.satori.doc.web.controller;

import com.satori.doc.svc.dal.po.DocPO;
import com.satori.doc.svc.service.IDocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author cat_y
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/doc")
public class DocController {
    private final IDocService docService;

    @GetMapping("/add")
    public String doc() {

        DocPO docPO = new DocPO();
//        docPO.setConfiguration("{\"a\":12}");
        docPO.setType(1);
        docPO.setName("1");
        docPO.setCreator("");
        docPO.setCreateTime(LocalDateTime.now());
        docPO.setCreatorId(1L);
        docService.save(docPO);
        return "suc";
    }

}
