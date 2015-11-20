package com.yhc.web.login.action;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yhc.common.action.BaseAction;
import com.yhc.common.model.SysUser;
import com.yhc.common.utils.EncryptUtil;
import com.yhc.web.user.service.UserService;

@Controller
@RequestMapping("/user")
public class LoginAction extends BaseAction {
	@Resource(name = "userService")
	private UserService userService;

	/**
	 * 用户注册
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public ModelAndView regist(@ModelAttribute("user") SysUser user) {
		ModelAndView mav = super.getModelAndView();
		try {
			//加密用户输入的密码，得到密码的摘要和盐，保存到数据库 
		    String password= EncryptUtil.md5Password(user.getLoginName(), user.getPassword());
		    if(StringUtils.isNotBlank(password)){
		    	 user.setPassword(password);
		    	 //create user
		    	 userService.addUserInfo(user);
		     }else{
		    	return getAlertNBackModelAndView("注册失败");
		     }
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("用户注册失败,用户信息：loginName"+user.getLoginName());
			return getAlertNBackModelAndView("注册失败");
		}
		mav=getRedirectModelAndView("/user/login_page.yhc");
		return mav;
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
		ModelAndView mav = new ModelAndView();
		try {

			Subject subject = SecurityUtils.getSubject();
			/**
			 * 已登陆则 跳到首页
			 * subject.isAuthenticated()表示用户进行了身份验证登录的，即使有Subject.login进行了登录；
			 * subject.isRemembered()：表示用户是通过记住我登录的，此时可能并不是真正的你（如你的朋友使用你的电脑，
			 * 或者你的cookie被窃取）在访问的；
			 * 且两者二选一，即subject.isAuthenticated()==true，则subject
			 * .isRemembered()==false；反之一样。
			 */
			if (subject.isAuthenticated() || subject.isRemembered()) {
				mav = getRedirectModelAndView("/user/view.yhc");
				return mav;
			}
			// 身份验证
			UsernamePasswordToken token = new UsernamePasswordToken(
					user.getLoginName(), user.getPassword());
			if (user.getRememberMe()) {
				token.setRememberMe(true);
			}

			subject.login(token);
			// 验证成功在Session中保存用户信息
			final SysUser authUserInfo = userService.selectByUsername(user
					.getLoginName());
		} catch (AuthenticationException e) {
			// 身份验证失败
			e.printStackTrace();
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
		ModelAndView mav = super.getModelAndView();

		// 登出操作
		Subject subject = SecurityUtils.getSubject();
		subject.logout();// session 会销毁，在SessionListener监听session销毁，清理权限缓存
		mav.setViewName("login");
		return mav;
	}
}
