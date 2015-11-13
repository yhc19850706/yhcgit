/**   
* SpringCoreTest.java 
* com.common.aop 
* @Description:
* @author Yhc yinhc@yinhu.com
* 2015年10月28日 下午5:49:06 
* @version V1.0   
*/
	
		package com.yhc.common.aop;

		/** 
 * @Project：AngularJs
 * @Package：com.common.aop
 * @ClassName: SpringCoreTest 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Yhc yinhc@yinhu.com
 * @date 2015年10月28日 下午5:49:06  
 */
		import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

		public class SpringCoreTest{
			
			public static void main(String[] args){
				ApplicationContext ctx = 
						new ClassPathXmlApplicationContext("applicationContext-config.xml");
				
//				AdvisedObj advisedObj = (AdvisedObj)ctx.getBean("advised");
//				advisedObj.perform();
			}
		}
	