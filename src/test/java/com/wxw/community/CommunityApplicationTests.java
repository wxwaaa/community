package com.wxw.community;

import com.wxw.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
	@Test
	public void testApplicationContext(){
		System.out.println("测试开始···");
		System.out.println(applicationContext);
		System.out.println("测试结束···");

	}

	@Test
	public void testBeanManagement(){
		AlphaService alphaService=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService);
		AlphaService alphaService1=applicationContext.getBean(AlphaService.class);
		System.out.println(alphaService1);

	}
	@Autowired
	private AlphaService alphaService;
	@Test
	public void alphaServiceDI(){
		System.out.println(alphaService);
	}

	@Test
	public void configTest(){
		SimpleDateFormat simpleDateFormat=applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}
}
