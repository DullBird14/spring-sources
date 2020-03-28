package org.geek.ioc.overview.dependent.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cys
 * @date 2020-03-07 15:29
 */

public class SafetySearchDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(SafetySearchDemo.class);
		//启动上下文
		context.refresh();
		// 单一的beanFactory 查找 unsafe
		beanFactorySearch(context);
		// 单一的 ObjectFacrory    unsafe
		objectFacrorySearch(context);
		// 单一的 ObjectProvider   safe
		objectProviderSearch(context);
		// 集合类型的查找          safe
		listableBeanFactorySearch(context);
		//          safe
		objectProviderSops(context);

		// 关闭上文文
		context.close();
	}

	private static void objectProviderSops(AnnotationConfigApplicationContext context) {
		ObjectProvider<String> objectProvider = context.getBeanProvider(String.class);
		printTrance("objectProviderSops", ()-> objectProvider.forEach(System.out::println));
	}

	private static void listableBeanFactorySearch(AnnotationConfigApplicationContext context) {
		ListableBeanFactory listableBeanFactory = context.getDefaultListableBeanFactory();
		printTrance("listableBeanFactorySearch", ()-> listableBeanFactory.getBeansOfType(String.class));
	}

	private static void objectProviderSearch(AnnotationConfigApplicationContext context) {
		ObjectProvider<String> objectProvider = context.getBeanProvider(String.class);
		printTrance("objectProviderSearch", objectProvider::getIfAvailable);
	}

	private static void objectFacrorySearch(AnnotationConfigApplicationContext context) {
		ObjectFactory<String> objectFactory = context.getBeanProvider(String.class);
		printTrance("objectFactorySearch", objectFactory::getObject);

	}

	private static void beanFactorySearch(AnnotationConfigApplicationContext context) {
		printTrance("beanFactorySearch", () -> context.getBeanFactory().getBean(String.class));
	}

	private static void printTrance(String origin , Runnable runnable) {
		System.err.println(origin);
		System.err.println("======================");
		try {
			runnable.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
