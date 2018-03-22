package com.yhc.lifeall;

import com.github.pagehelper.PageHelper;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Properties;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.yhc.lifeall.mapper")
@EnableScheduling
@ServletComponentScan
public class LifeallApplication {

	public static void main(String[] args) {
		SpringApplication.run(LifeallApplication.class, args);
	}

	@Bean
	public TaskScheduler taskScheduler(){
		ThreadPoolTaskScheduler threadPoolTaskScheduler= new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(100);
		threadPoolTaskScheduler.setThreadNamePrefix("crawl-task");
		return threadPoolTaskScheduler;
	}

	//添加HTTP自动转向HTTPS的功能
//	@Bean
//	public EmbeddedServletContainerFactory servletContainer() {
//		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
//			@Override
//			protected void postProcessContext(Context context) {
//				SecurityConstraint constraint = new SecurityConstraint();
//				constraint.setUserConstraint("CONFIDENTIAL");
//				SecurityCollection collection = new SecurityCollection();
//				collection.addPattern("/*");
//				constraint.addCollection(collection);
//				context.addConstraint(constraint);
//			}
//		};
//		tomcat.addAdditionalTomcatConnectors(httpConnector());
//		return tomcat;
//	}
//
//	@Bean
//	public Connector httpConnector() {
//		Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//		connector.setScheme("http");
//		//Connector监听的http的端口号
//		connector.setPort(8080);
//		connector.setSecure(false);
//		//监听到http的端口号后转向到的https的端口号
//		connector.setRedirectPort(8443);
//		return connector;
//	}
}
