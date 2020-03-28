package org.dullbird.demo.resource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cys
 * @date 2019-12-22 22:27
 */

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ResourceConfiguration.class);

		ResourceBeanA bean = context.getBean(ResourceBeanA.class);
		ResourceBeanB beanB = context.getBean(ResourceBeanB.class);
		bean.say();
		beanB.say();
	}
}
