package org.geek.ioc.overview.dependent.initialization;

import org.geek.ioc.overview.dependent.factory.DefaultUserFactory;
import org.geek.ioc.overview.dependent.factory.UserFactory;
import org.geek.ioc.overview.dependent.instantiation.BeanInstantiationDemo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cys
 * @date 2020-03-02 21:57
 */
@Configuration
public class BeanInitializationDemo {

	@Bean(initMethod = "beanInit", destroyMethod = "selfDestroy")
	public UserFactory createUserFactoryBean() {
		return new DefaultUserFactory();
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanInitializationDemo.class);

		// 启动容器
		context.refresh();
		System.out.println("spring容器已启动...");

		context.getBean(UserFactory.class);
		System.out.println("spring容器准备关闭");
		// 关闭容器
		context.close();
		System.out.println("spring容器已关闭...");

	}
}
