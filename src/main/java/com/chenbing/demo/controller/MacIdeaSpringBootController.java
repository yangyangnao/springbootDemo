package com.chenbing.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("soldier")
public class MacIdeaSpringBootController {

    Logger logger = Logger.getLogger(MacIdeaSpringBootController.class);
    @RequestMapping(value="hello")
    public String hello(){
        logger.debug("陈兵");
        logger.error("陈兵");
        logger.info("陈兵");
        return "这是我在mac上使用idea手动建立的springboot Demo工程";
    }
}
