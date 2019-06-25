package com.sti.ssm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class StiSsmController {

    @GetMapping(value = "/test")
    public @ResponseBody String test() {
        log.debug("testing");
        return "Test";
    }
}
