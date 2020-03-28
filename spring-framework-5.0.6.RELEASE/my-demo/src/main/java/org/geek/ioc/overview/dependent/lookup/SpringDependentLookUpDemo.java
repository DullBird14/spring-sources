package org.geek.ioc.overview.dependent.lookup;

import org.geek.ioc.overview.dependent.config.MainConfiguration;
import org.geek.ioc.overview.dependent.domain.User;
import org.geek.ioc.overview.dependent.domain.UserObjectFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;
import java.util.Map;

/**
 * @author cys
 * @date 2020-01-05 11:14
 */

public class SpringDependentLookUpDemo {
	public static void main(String[] args) {
		BeanFactory beanFactory = new AnnotationConfigApplicationContext(MainConfiguration.class);
//		lookUpByname(beanFactory);
//		lookUpDelay(beanFactory);
		lookupCollectionByType(beanFactory);

	}


	private static void lookupCollectionByType(BeanFactory beanFactory) {
		if (beanFactory instanceof ListableBeanFactory) {
			ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
			Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
			System.out.println(beans);
		}
	}

	private static void lookUpDelay(BeanFactory beanFactory) {
		ObjectFactory<User> factory = beanFactory.getBean(UserObjectFactory.class);
		User user = factory.getObject();
		System.out.println("==============lookUpDelay User=======");

		System.out.println(user);
	}

	private static void lookUpByname(BeanFactory beanFactory) {
		User user = (User)beanFactory.getBean("user");
		System.out.println(user);
	}
}
