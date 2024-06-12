package com.satori.doc.web.controller;

import com.satori.doc.model.vo.ResultVO;
import com.satori.doc.svc.dto.resp.doc.DocListRespDTO;
import com.satori.doc.svc.dto.resp.doc.DocRespDTO;
import com.satori.doc.svc.service.IDocService;
import com.satori.doc.web.model.req.doc.DocAddRequest;
import com.satori.doc.web.model.resp.DocListResponse;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cat_y
 */

@Api(tags = "文档管理API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/doc")
public class DocController {
    private final IDocService docService;

    @PostMapping("/add")
    public ResultVO<Long> add(@RequestBody @Validated DocAddRequest request) {
        return ResultVO.success(docService.save(request.getName(), request.getType()));
    }

    @GetMapping("/get/{id}")
    public ResultVO<?> get(@PathVariable Long id) {
        DocRespDTO docResp = docService.get(id);
        System.out.println(docResp);
        return ResultVO.success();
    }

    @GetMapping("/create/{id}")
    public ResultVO<String> create(@PathVariable Long id) {
        String path = docService.create(id);
        return ResultVO.success(path);
    }

    @GetMapping("/list/all")
    public ResultVO<List<DocListResponse>> listAll() {
        List<DocListRespDTO> dtoList = docService.listAll();
        List<DocListResponse> respList = new ArrayList<>();
        dtoList.forEach(dto -> {
            DocListResponse resp = new DocListResponse();
            BeanUtils.copyProperties(dto, resp);
            respList.add(resp);
        });
        return ResultVO.success(respList);
    }
}
