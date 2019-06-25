package com.sti.ssm.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StiSsmController {

    @Autowired
    private Logger logger;

    @GetMapping(value = "/test")
    public @ResponseBody String test() {
        logger.debug("testing");
        return "Test";
    }
}
