package org.geek.ioc.overview.dependent.registry;

import org.geek.ioc.overview.dependent.factory.DefaultUserFactory;
import org.geek.ioc.overview.dependent.factory.UserFactory;
import org.geek.ioc.overview.dependent.initialization.BeanInitializationDemo;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cys
 * @date 2020-03-03 23:51
 */

public class SingletonBeanRegistryDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		// 启动容器
		context.refresh();
		System.out.println("spring容器已启动...");
		ConfigurableListableBeanFactory factory = context.getBeanFactory();
		DefaultUserFactory defaultUserFactory = new DefaultUserFactory();
		factory.registerSingleton("userFactory", defaultUserFactory);

		UserFactory bean = context.getBean(UserFactory.class);
		System.out.println(defaultUserFactory == bean);

		// 关闭容器
		context.close();

	}
}
