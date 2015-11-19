package com.yhc.web.user.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yhc.common.action.BaseAction;
import com.yhc.common.annotation.IfNeedSecurity;
import com.yhc.common.annotation.SystemControllerLog;
import com.yhc.common.model.Response;
import com.yhc.common.model.SysUser;
import com.yhc.common.model.UserInfo;
import com.yhc.web.security.PermissionSign;
import com.yhc.web.security.RoleSign;
import com.yhc.web.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserAction  extends BaseAction{
	@Resource(name="userService")
	private UserService userService;
	
    @RequestMapping("/view.yhc")
    public ModelAndView view() throws Exception{
    	ModelAndView mav=super.getModelAndView();
    	SysUser user = new SysUser();
        user=userService.getUserByUserId("1");
        mav.addObject("user", user);
        mav.setViewName("managepage/index");
//        String commonCdString=ContextUtil.getCommonCodeMap().get("CORPPROPERTY05");
//        System.out.println("-------------commonCdString------------"+commonCdString);
        return mav;
    }

    @RequestMapping("/login_page.yhc")
    public ModelAndView loginPage() {
    	ModelAndView mav=new ModelAndView();
    	
        mav.setViewName("login");
//        String commonCdString=ContextUtil.getCommonCodeMap().get("CORPPROPERTY05");
//        System.out.println("-------------commonCdString------------"+commonCdString);
        return mav;
    }
    /**
	 * 
	 * @MethodName:createAdvertiser
	 * @param advertiserParam
	 * @return Response
	 * @Description: @Valid  验证参数
	 * @author Yhc yinhc@yinhu.com
	 */
	@RequestMapping(value = "/advertiser.yhc", method = RequestMethod.GET)
	@IfNeedSecurity(methodSecrity = "删除用户") 
	public  Response createAdvertiser(@RequestParam String advertiserName) {
		        Response response=new Response();
		        response.success();
		        return response;
		    }
	
	@RequestMapping(value = "/advertiser2.yhc", method = RequestMethod.GET)
	@SystemControllerLog(description="修改0000")
	public Response updateAdertiser(){
		Response response=new Response();
        response.success("advertiser2");
        return response;
	}

	    /**
	     * 用户登录
	     * 
	     * @param user
	     * @param result
	     * @return
	     */
	    @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public ModelAndView login(@ModelAttribute("user") SysUser user) {
	    	ModelAndView mav=new ModelAndView();
	        try {
	        	
	            Subject subject = SecurityUtils.getSubject();
	            // 已登陆则 跳到首页
	            if (subject.isAuthenticated()) {
	            	mav=getRedirectModelAndView("/user/view.yhc");
	                return mav;
	            }
	            // 身份验证
	            subject.login(new UsernamePasswordToken(user.getLoginName(), user.getPassword()));
	            // 验证成功在Session中保存用户信息
	            final SysUser authUserInfo = userService.selectByUsername(user.getLoginName());
	        } catch (AuthenticationException e) {
	            // 身份验证失败
	        	
	            return getRedirectModelAndView("/user/login_page.yhc");
	        } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return getRedirectModelAndView("/user/view.yhc");
	    }

	    /**
	     * 用户登出
	     * 
	     * @param session
	     * @return
	     */
	    @RequestMapping(value = "/logout", method = RequestMethod.GET)
	    public ModelAndView logout() {
	    	ModelAndView mav=super.getModelAndView();
	    	
	        // 登出操作
	        Subject subject = SecurityUtils.getSubject();
	        subject.logout();
	        mav.setViewName("login");
	        return mav;
	    }

	    /**
	     * 基于角色 标识的权限控制案例
	     */
	    @RequestMapping(value = "/admin.yhc")
	    @ResponseBody
	    @RequiresRoles(value = RoleSign.ADMIN)
	    public String admin() {
	        return "拥有admin角色,能访问";
	    }

	    /**
	     * 基于权限标识的权限控制案例
	     */
	    @RequestMapping(value = "/create.yhc")
	    @ResponseBody
	    @RequiresPermissions(value = PermissionSign.MENU_VIEW)
	    public String create() {
	    	System.out.println("拥有"+PermissionSign.MENU_VIEW+"权限,能访问");
	        return "拥有user:create权限,能访问";
	    }
}
