package org.geek.ioc.environment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月19日 23:31:00
 */
public class YmlConfigurationDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.refresh();
		MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
		propertySources.forEach(System.out::println);
		context.close();
	}
}
