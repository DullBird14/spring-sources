package org.geek.ioc.dependency.injection;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 测试
 * @see org.springframework.beans.factory.support.DefaultListableBeanFactory
 *
 * @author cys
 * @date 2020-03-07 22:01
 */

public class ResourceAnnotationInjectionResolutionnDemo {


	@Resource(type = User.class)
	private User haha;

//	@Resource
//	private Integer testNotFindBeanResource;
	@Autowired
	private Integer testNotFindBeanAutowired;


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 注入xml情况下的bean
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
		reader.loadBeanDefinitions("classpath:/beans/bean-lookup-injection.xml");
		context.register(ResourceAnnotationInjectionResolutionnDemo.class);
		context.refresh();
		ResourceAnnotationInjectionResolutionnDemo demo = context.getBean(ResourceAnnotationInjectionResolutionnDemo.class);
		System.out.println(demo.testNotFindBeanAutowired);
//		System.out.println(demo.testNotFindBeanResource);
		context.close();
	}

	@Bean
	public User test(){
		return User.createUser();
	}
}
