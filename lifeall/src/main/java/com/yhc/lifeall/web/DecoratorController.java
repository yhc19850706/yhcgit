package com.yhc.lifeall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/decorators/")
public class DecoratorController {
    @RequestMapping("mainpage")
    public String defaultDecorator() {
        return "/decorators/mainpage";
    }
}
