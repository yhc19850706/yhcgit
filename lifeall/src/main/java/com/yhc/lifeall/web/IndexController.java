package com.yhc.lifeall.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/")
public class IndexController {
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
