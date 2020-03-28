package org.geek.ioc.overview.dependent.instantiation;

import org.geek.ioc.overview.dependent.domain.User;
import org.geek.ioc.overview.dependent.factory.UserFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author cys
 * @date 2020-03-02 21:57
 */

public class SpecialBeanInstantiationDemo {
	public static void main(String[] args) {
		// 通过ServiceLoaderFactoryBean创建
//		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/beans/special-bean-instantiation.xml");
//		ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userServiceClassLoaderFactoryBean", ServiceLoader.class);
//		Iterator<UserFactory> iterator = serviceLoader.iterator();
//		while (iterator.hasNext()){
//			User user = iterator.next().getUser();
//			System.out.println(user);
//		}
		// 通过AutowireCapableBeanFactory直接创建
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext("classpath:/beans/special-bean-instantiation.xml");
		AutowireCapableBeanFactory autowireCapableBeanFactory = beanFactory.getAutowireCapableBeanFactory();
		User factoryBean = autowireCapableBeanFactory.createBean(User.class);
		System.out.println(factoryBean);

	}
}
