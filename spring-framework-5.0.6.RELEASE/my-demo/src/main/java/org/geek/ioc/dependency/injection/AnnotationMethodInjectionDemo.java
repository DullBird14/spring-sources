package org.geek.ioc.dependency.injection;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * 注解形式主动注入
 * @author cys
 * @date 2020-03-07 22:01
 */

public class AnnotationMethodInjectionDemo {

	private UserHolder userHolder;
	private UserHolder userHolder2;
	@Autowired
	public void init1(UserHolder userHolder){
		this.userHolder = userHolder;
	}
	@Resource
	public void init2(UserHolder userHolder2){
		this.userHolder2 = userHolder2;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 注入xml情况下的bean
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
		reader.loadBeanDefinitions("classpath:/beans/bean-lookup-injection.xml");
		context.register(AnnotationMethodInjectionDemo.class);
		context.refresh();

		AnnotationMethodInjectionDemo demo = context.getBean(AnnotationMethodInjectionDemo.class);
		System.out.println(demo.userHolder);
		System.out.println(demo.userHolder2);
		System.out.println(demo.userHolder2 == demo.userHolder);

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
