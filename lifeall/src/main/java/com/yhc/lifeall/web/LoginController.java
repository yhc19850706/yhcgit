package com.yhc.lifeall.web;

import com.google.common.collect.Maps;
import com.yhc.lifeall.common.utils.CookieUtil;
import com.yhc.lifeall.common.utils.MD5Util;
import com.yhc.lifeall.common.utils.ResultInfo;
import com.yhc.lifeall.common.utils.ResultUtil;
import com.yhc.lifeall.mapper.sysdata.UserMapper;
import com.yhc.lifeall.model.sysdata.User;
import com.yhc.lifeall.service.UserService;
import com.yhc.lifeall.system.redis.RedisUtil;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;
    @Value("${md5.password}")
    private String miyao;
    @RequestMapping(value = "/login")
    @ResponseBody
    public ResultInfo login(HttpServletResponse response,@RequestParam("userName") String userName,@RequestParam("password") String password) {
        User user = userService.queryUserByUserName(userName);
        Map map= Maps.newHashMap();
        if (user != null&&user.getPassword().equals(MD5Util.getMD5(password))) {
            //2. 设置token至redis
            String token = UUID.randomUUID().toString().replace("-","");
            //3. 设置token至cookie
            CookieUtil.set(response, CookieUtil.TOKEN, token, CookieUtil.EXPIRE);
            redisUtil.set(token,user,3600L);
            return ResultUtil.success();
        }
        return ResultUtil.error(1000,"用户不存在");
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response) {
        //1. 从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieUtil.TOKEN);
        if (cookie != null) {
            //3. 清除cookie
            CookieUtil.set(response, CookieUtil.TOKEN, null, 0);
            redisUtil.remove(cookie.getValue());
        }
        return new ModelAndView("login");
    }
    @RequestMapping("/goregist")
    public ModelAndView goregist(){
        return new ModelAndView("register");
    }

    @RequestMapping("/gologin")
    public ModelAndView gologin(){
        return new ModelAndView("login");
    }

    @RequestMapping("/regist")
    @ResponseBody
    public ResultInfo register(User user){
        if(user!=null){
            if (StringUtils.isNotBlank(user.getUserName()) && StringUtils.isNotBlank(user.getPassword())) {
                User u= userService.queryUserByUserName(user.getUserName());
                if(u==null){
                    user.setDelYn(true);
                    user.setPassword(MD5Util.getMD5(user.getPassword()));
                    userService.insertUser(user);
                    return ResultUtil.success();
                }else{
                    return ResultUtil.error(1000,"用户名已存在!");
                }
            }
        }
        return ResultUtil.error(1000,"请输入正确的用户信息");
    }
}
