package com.yhc.common.databind;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yhc.common.action.BaseAction;

@Controller
@RequestMapping(value = "/foc")
public class FormObjController extends BaseAction{
  
    @RequestMapping("/test1.yhc")
    public @ResponseBody String test1(@MyForm Dept dept, @MyForm Employee emp) {
        return "index";
    }
    
    @RequestMapping("/test2.yhc")
    public @ResponseBody  String test2(@MyForm("d") Dept dept, @MyForm("e") Employee emp) {
        return "index";
    }
    
    @RequestMapping("/test3.yhc")
    public @ResponseBody String test3(@MyForm(value = "d", show = false) Dept dept, @MyForm("e") Employee emp) {
        return "index";
    }
  
}
