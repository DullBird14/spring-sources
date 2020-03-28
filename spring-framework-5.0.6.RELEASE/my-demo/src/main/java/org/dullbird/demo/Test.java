package org.dullbird.demo;

import org.dullbird.demo.bean.TestUser;
import org.dullbird.demo.config.MainConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cys
 * @date 2019-12-22 22:27
 */

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);

		TestUser bean = context.getBean(TestUser.class);
		System.out.println(bean);
//		LookupDemo bean = context.getBean(LookupDemo.class);
//		LookupUser userA = bean.invokeAndReturnNewUser();
//		LookupUser userB = bean.invokeAndReturnNewUser();
//		System.out.println(userA);
//		System.out.println(userB);
//		System.out.println(userA == userB);

	}
}
