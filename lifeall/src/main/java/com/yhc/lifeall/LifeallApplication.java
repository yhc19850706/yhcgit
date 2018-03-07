package com.yhc.lifeall;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Properties;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@MapperScan("com.yhc.lifeall.mapper")
@EnableScheduling
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
}
