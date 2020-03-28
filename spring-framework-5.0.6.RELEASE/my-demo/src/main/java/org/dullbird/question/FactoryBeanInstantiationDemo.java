package org.dullbird.question;

import org.geek.ioc.overview.dependent.domain.SuperUser;
import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * bean初始化之前的操作,提供一个拦截点，可以绕过spring的初始化。如果返回了对象。后面将不再执行
 * InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation
 *
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年03月15日 23:21:00
 * @see InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation
 */
public class FactoryBeanInstantiationDemo {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		// 需要一个 beanFactoryRegistry
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		int i = reader.loadBeanDefinitions("classpath:/beans/factoryBeanDemo.xml");
		String bean = factory.getBean(String.class);
		System.out.println(bean);
	}
}
