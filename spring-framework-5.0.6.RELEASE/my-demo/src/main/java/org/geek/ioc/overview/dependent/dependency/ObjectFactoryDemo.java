package org.geek.ioc.overview.dependent.dependency;

import org.geek.ioc.overview.dependent.domain.User;
import org.geek.ioc.overview.dependent.domain.UserObjectFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author cys
 * @date 2020-03-04 23:04
 */

public class ObjectFactoryDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ObjectFactoryDemo.class);
		context.refresh();
		lookUpBeanByObjectFactory(context);
		context.close();
	}
	@Bean
	public String createStringBean() {
		return "Hello,word";
	}

	private static void lookUpBeanByObjectFactory(AnnotationConfigApplicationContext context) {
//		context.getBeanProvider() spring 5.1可以调用的方法。效果和下面一样。
		ObjectFactory<User> factory = context.getBean(UserObjectFactory.class);
		User user = factory.getObject();
		System.out.println("==============lookUpDelay User=======");

		System.out.println(user);
	}
}
