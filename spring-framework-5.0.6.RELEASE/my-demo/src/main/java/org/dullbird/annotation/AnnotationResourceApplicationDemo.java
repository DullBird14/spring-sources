package org.dullbird.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月25日 23:03:00
 */
public class AnnotationResourceApplicationDemo {
//	@Bean
//	public String test() {
//		return "my-test";
//	}
	@Bean
	public Object test() {
		return new Object();
	}
	@Bean
	public String testOne() {
		return "my-One";
	}
	@Resource
	public String test;


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AnnotationResourceApplicationDemo.class);
		AnnotationResourceApplicationDemo bean = context.getBean(AnnotationResourceApplicationDemo.class);
		System.out.println(bean.test);
		context.close();
	}
}
