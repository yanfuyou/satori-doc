package com.satori.doc.web.controller;

import com.satori.doc.model.vo.ResultVO;
import com.satori.doc.svc.dto.req.paragraph.ParagraphReqDTO;
import com.satori.doc.svc.service.IParagraphService;
import com.satori.doc.web.model.req.paragraph.ParagraphRequest;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author cat_y
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/paragraph")
public class ParagraphController {

    private final IParagraphService paragraphService;

    @Operation(summary = "添加段落")
    @PostMapping("/add")
    public ResultVO<Long> add(@RequestBody ParagraphRequest request) {
        ParagraphReqDTO req = new ParagraphReqDTO();
        BeanUtils.copyProperties(request, req);
        return ResultVO.success(paragraphService.add(req));
    }

}
