package org.geek.ioc.overview.dependent.dependency;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Objects;

/**
 * @author cys
 * @date 2020-03-05 23:07
 */

public class ConfigurableListableBeanFactoryDemo {
	public static void main(String[] args) {
		// 第一个spring上下文
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ConfigurableListableBeanFactoryDemo.class);
		ConfigurableListableBeanFactory factory = context.getBeanFactory();
		System.out.println(factory.getParentBeanFactory());
		// 第二个spring上下文
		ClassPathXmlApplicationContext xmlContext = new ClassPathXmlApplicationContext("classpath:/beans/spring-bean-instantiation.xml");
		ConfigurableListableBeanFactory parentFactory = xmlContext.getBeanFactory();
		factory.setParentBeanFactory(parentFactory);
		System.out.println(factory.getParentBeanFactory());

//		hierarchicalLocalBeanSearch(factory, "userFactoryBean");
//		hierarchicalLocalBeanSearch(parentFactory, "userFactoryBean");
		testBeanFactoryUtilsSearchBeans(factory, parentFactory);
		context.refresh();
		context.close();
	}

	private static void testBeanFactoryUtilsSearchBeans(ConfigurableListableBeanFactory factory,
	                                                    ConfigurableListableBeanFactory parentFactory) {
		factory.registerSingleton("test", "hahaha");
		parentFactory.registerSingleton("test", "xixixixi");
		Map<String, String> stringStringMap = BeanFactoryUtils.beansOfTypeIncludingAncestors(factory, String.class);
		//{test=hahaha}
		// 说明最后子类的对象会覆盖父类的
		System.out.println(stringStringMap);
	}

	private static void hierarchicalLocalBeanSearch(ConfigurableListableBeanFactory factory, String beanName){
		System.out.printf("beanFactory 为 %s , 查找的beanName为【%s】,查找的结果是[%s]\n", factory, beanName,
				factory.containsLocalBean(beanName));
	}
	private static boolean loopSearchBean(BeanFactory factory, String beanName) {
		if (factory instanceof HierarchicalBeanFactory) {
			HierarchicalBeanFactory beanFactory = HierarchicalBeanFactory.class.cast(factory);
			BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
			if (Objects.nonNull(parentBeanFactory)
					&& loopSearchBean(parentBeanFactory, beanName)) {
				return true;
			}
			return beanFactory.containsLocalBean(beanName);
		}
		return factory.containsBean(beanName);
	}
}
