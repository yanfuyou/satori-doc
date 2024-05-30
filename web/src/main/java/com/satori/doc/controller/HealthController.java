package com.satori.doc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cat_y
 */
@RestController
public class HealthController {

    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "success";
    }
}
