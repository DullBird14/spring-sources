package org.geek.ioc.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年03月28日 21:19:00
 */
public class TenthBeanInitializationDemo implements InitializingBean, SmartInitializingSingleton {

	private String message;

	public static void main(String[] args) {
		beanFactoryAwareInjection();
	}

	private static void beanFactoryAwareInjection() {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		factory.addBeanPostProcessor(new BeanPostProcessor() {
			@Override
			public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
				if ("tenthDemo".equals(beanName)
						&& bean.getClass().equals(TenthBeanInitializationDemo.class)) {
					TenthBeanInitializationDemo demo = TenthBeanInitializationDemo.class.cast(bean);
					demo.printMessage();
					demo.setMessage("postProcessBeforeInitialization set :version V2");
				}
				return bean;
			}

			@Override
			public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
				if ("tenthDemo".equals(beanName)
						&& bean.getClass().equals(TenthBeanInitializationDemo.class)) {
					TenthBeanInitializationDemo demo = TenthBeanInitializationDemo.class.cast(bean);
					demo.printMessage();
					demo.setMessage("postProcessAfterInitialization set :version V3");
				}
				return bean;
			}
		});
		factory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());
		// 需要一个 beanFactoryRegistry
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		int i = reader.loadBeanDefinitions("classpath:/META-INF/ten-Initialization-demo.xml");
		TenthBeanInitializationDemo demo = factory.getBean("tenthDemo", TenthBeanInitializationDemo.class);
		// 触发 SmartInitializingSingleton 的调用
		factory.preInstantiateSingletons();
		demo.printMessage();
	}

	public void init() throws Exception {
		this.printMessage();
		this.setMessage("init set : version V6");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.printMessage();
		this.setMessage("afterPropertiesSet set : version V5");
	}

	/**
	 * 一次没生效，为什么呢？因为PostConstruct的处理需要一个特定的处理器
	 */
	@PostConstruct
	private void postConstruct() {
		this.printMessage();
		this.setMessage("PostConstruct set : version V4");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void printMessage() {
		System.out.println("======================" + message + "=================");
	}


	@Override
	public void afterSingletonsInstantiated() {
		this.printMessage();
		this.setMessage("afterSingletonsInstantiated set : version V7");
	}
}
