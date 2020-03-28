package org.geek.ioc.overview.dependent.instantiation;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cys
 * @date 2020-03-02 21:57
 */

public class BeanInstantiationDemo {
	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/beans/spring-bean-instantiation.xml");
		User bean = beanFactory.getBean("get-user-by-instance-method", User.class);
		User userByStaticMethod = beanFactory.getBean("get-user-by-static-method", User.class);
		User userByfactoryBean = beanFactory.getBean("userFactoryBean", User.class);
		System.out.println(bean);
		System.out.println(userByStaticMethod);
		System.out.println(userByfactoryBean);
		System.out.println(userByStaticMethod == bean);
		System.out.println(userByfactoryBean == bean);
	}
}
