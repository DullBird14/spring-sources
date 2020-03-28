package org.geek.ioc.dependency.source;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * bean 内建的非bean对象。依赖查找不可以访问，依赖注入可以
 *
 * @see AbstractApplicationContext#prepareBeanFactory
 * @see ConfigurableListableBeanFactory#registerResolvableDependency
 * @author dullBird
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月14日 17:37:00
 */
public class ResolvableDependencyDemo {
	@Autowired(required = false)
	private BeanFactory beanFactory;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ResolvableDependencyDemo.class);
		// 启动spring上下文
		applicationContext.refresh();
		ResolvableDependencyDemo demo = applicationContext.getBean(ResolvableDependencyDemo.class);
		//可以找到
		System.out.println("inject bean :" + demo.beanFactory);
		try {
			/**
			 * org.springframework.beans.factory.NoSuchBeanDefinitionException:
			 * No qualifying bean of type 'org.springframework.beans.factory.BeanFactory' available
			 */
			BeanFactory beanFactory = applicationContext.getBean(BeanFactory.class);
			System.out.println("lookup bean :" + beanFactory);
		} catch (Exception e) {
			System.out.println(e);
		}
		//

		// 关闭spring上下文
		applicationContext.close();
	}
}
