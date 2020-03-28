package org.geek.ioc.lifecycle;

import org.geek.ioc.overview.dependent.domain.SuperUser;
import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年03月28日 21:19:00
 */
public class NinthAwareInjectionDemo implements BeanNameAware, BeanClassLoaderAware,
		BeanFactoryAware, ApplicationContextAware {
	private String name;
	private ClassLoader classLoader;
	private BeanFactory beanFactory;
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		beanFactoryAwareInjection();
		System.out.println("=====================分割线===================");
		applicationAwareInjection();
	}

	private static void applicationAwareInjection() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/aware-injection-demo.xml");
		context.refresh();
		NinthAwareInjectionDemo demo = context.getBean("awareDemo", NinthAwareInjectionDemo.class);
		System.out.println(demo.name);
		System.out.println(demo.classLoader);
		System.out.println(demo.beanFactory);
		System.out.println(demo.applicationContext);
		context.close();
		/**
		 * 结果:
		 * awareDemo
		 * sun.misc.Launcher$AppClassLoader@18b4aac2
		 * org.springframework.beans.factory.support.DefaultListableBeanFactory@33cb5951: defining beans [awareDemo]; root of factory hierarchy
		 * org.springframework.context.support.ClassPathXmlApplicationContext@954b04f: startup date [Sat Mar 28 21:45:00 CST 2020]; root of context hierarchy
		 */
	}

	private static void beanFactoryAwareInjection() {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

		// 需要一个 beanFactoryRegistry
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		int i = reader.loadBeanDefinitions("classpath:/META-INF/aware-injection-demo.xml");
		NinthAwareInjectionDemo demo = factory.getBean("awareDemo", NinthAwareInjectionDemo.class);
		System.out.println(demo.name);
		System.out.println(demo.classLoader);
		System.out.println(demo.beanFactory);
		/**
		 * 结果:
		 * awareDemo
		 * sun.misc.Launcher$AppClassLoader@18b4aac2
		 * org.springframework.beans.factory.support.DefaultListableBeanFactory@18bf3d14: defining beans [awareDemo]; root of factory hierarchy
		 */
		//注入不进来，因为 ApplicationContextAware 是ApplicationContextAwareProcessor这个接口处理的。
		// 我们要注入这个接口。但是这个接口包级私有的
		System.out.println(demo.applicationContext);
	}

	@Override
	public void setBeanName(String name) {
		this.name = name;
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
