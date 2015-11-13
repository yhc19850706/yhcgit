/**   
 * TokenManager.java 
 * com.common.token 
 * @Description:
 * @author Yhc yinhc@yinhu.com
 * 2015年10月27日 下午5:13:02 
 * @version V1.0   
 */

package com.yhc.web.token.service;

/**
 * @Project：AngularJs
 * @Package：com.common.token
 * @ClassName: TokenManager
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Yhc yinhc@yinhu.com
 * @date 2015年10月27日 下午5:13:02
 */
public interface TokenManager {

	String createToken(String username);

	boolean checkToken(String token);
}
