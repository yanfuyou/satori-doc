package com.satori.doc.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author cat_y
 */

@ComponentScan(basePackages = {"com.satori.doc.svc"})
@MapperScan(basePackages = {"com.satori.doc.svc.dal.mapper"})
@Configuration
public class WebConfiguration {
}
