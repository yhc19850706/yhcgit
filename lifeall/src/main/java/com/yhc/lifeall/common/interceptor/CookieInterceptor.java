package com.yhc.lifeall.common.interceptor;

import com.yhc.lifeall.common.utils.CookieUtil;
import com.yhc.lifeall.model.sysdata.User;
import com.yhc.lifeall.system.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        System.out.println(">>>CookieInterceptor>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null || cookies.length == 0) {
            throw new Exception("illegal Login");
        }
        try {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(CookieUtil.TOKEN)) {
                    User user =(User) redisUtil.get(cookie.getValue());
                    if(user!=null){
                        CookieUtil.set(httpServletResponse, CookieUtil.TOKEN, cookie.getValue(), CookieUtil.EXPIRE);
                    }else {
                        return false;
                    }
                    return true;
                }
            }
            throw new Exception("illegal Login");
        } catch (Exception exp) {
            throw exp;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println(">>>CookieInterceptor>>>>>>>请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println(">>>CookieInterceptor>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}