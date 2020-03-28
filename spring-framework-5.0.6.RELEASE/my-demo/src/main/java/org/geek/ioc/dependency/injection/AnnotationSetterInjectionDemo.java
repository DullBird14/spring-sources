package org.geek.ioc.dependency.injection;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 注解形式主动注入
 * @author cys
 * @date 2020-03-07 22:01
 */

public class AnnotationSetterInjectionDemo{
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 注入xml情况下的bean
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
		reader.loadBeanDefinitions("classpath:/beans/bean-lookup-injection.xml");
		context.register(AnnotationSetterInjectionDemo.class);
		context.refresh();

		UserHolder bean = context.getBean(UserHolder.class);
		System.out.println(bean);

		context.close();
	}

	/**
	 * 此处根据类型+bean名字帮我注入了user
	 * @param user
	 * @return
	 */
	@Bean
	public UserHolder userHolder(User user){
		return new UserHolder(user);
	}
}
