package org.geek.ioc.dependency.injection;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
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

public class MyAutowireBeanPostProcessorDemo {

	@Autowired
	private User user;

	/**
	 * 注册 BeanPostProcessor 之后 会导致 MyAutowireBeanPostProcessorDemo的生命周期提前。
	 * 导致 User user 注入不进去
	 * @return
	 */
	@Bean
	public AutowiredAnnotationBeanPostProcessor annotationBeanPostProcessor(){
		AutowiredAnnotationBeanPostProcessor postProcessor = new AutowiredAnnotationBeanPostProcessor();
		return postProcessor;
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 注入xml情况下的bean
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
		reader.loadBeanDefinitions("classpath:/beans/bean-lookup-injection.xml");
		context.register(MyAutowireBeanPostProcessorDemo.class);
		context.refresh();
		MyAutowireBeanPostProcessorDemo bean = context.getBean(MyAutowireBeanPostProcessorDemo.class);
		System.out.println(bean.user);
		context.close();
	}

	@Bean
	public User test(){
		return User.createUser();
	}
}
