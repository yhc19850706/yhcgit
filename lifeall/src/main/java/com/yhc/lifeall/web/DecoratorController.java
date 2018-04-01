package com.yhc.lifeall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/decorators/")
public class DecoratorController {
    @RequestMapping("mainpage")
    public String mainDecorator() {
        return "/decorators/mainpage";
    }
    @RequestMapping("common")
    public String defaultDecorator() {
        return "/decorators/common";
    }
}
