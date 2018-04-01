package com.yhc.lifeall.web;


import com.google.common.collect.Maps;
import com.yhc.lifeall.system.redis.RedisUtil;
import com.yhc.weixin.api.TokenAPI;
import com.yhc.weixin.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/")
public class IndexController {

//    @RequestMapping("/")
//    public void redirect(HttpServletResponse response) throws IOException {
//        response.sendRedirect("/index.i");
//    }
    @RequestMapping("/index.i")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
