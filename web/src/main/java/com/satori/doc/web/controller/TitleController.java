package com.satori.doc.web.controller;

import com.satori.doc.model.vo.ResultVO;
import com.satori.doc.svc.dto.req.title.TitleAddReqDTO;
import com.satori.doc.svc.service.ITitleService;
import com.satori.doc.web.model.req.title.TitleAddRequest;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cat_y
 */

@Api(tags = "标题管理API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/title")
public class TitleController {

    private final ITitleService titleService;

    @Operation(summary = "添加标题")
    @PostMapping("/add")
    public ResultVO<Long> add(@RequestBody @Validated TitleAddRequest request) {
        TitleAddReqDTO req = new TitleAddReqDTO();
        BeanUtils.copyProperties(request, req);
        return ResultVO.success(titleService.add(req));
    }

}
