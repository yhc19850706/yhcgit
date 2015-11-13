package com.yhc.web.user.action;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yhc.common.action.BaseAction;
import com.yhc.common.annotation.IfNeedSecurity;
import com.yhc.common.annotation.SystemControllerLog;
import com.yhc.common.model.Response;
import com.yhc.common.model.UserInfo;
import com.yhc.common.utils.ContextUtil;
import com.yhc.web.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserAction  extends BaseAction{
	@Resource(name="userService")
	private UserService userService;
	
    @RequestMapping("/view.yhc")
    public ModelAndView view(@RequestParam("id") Long id) {
    	ModelAndView mav=super.getModelAndView();
    	UserInfo user = new UserInfo();
        user=userService.getUserByUserId("05f7d8a4d0254ccc81cd250ffe1cbf78");
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

}
