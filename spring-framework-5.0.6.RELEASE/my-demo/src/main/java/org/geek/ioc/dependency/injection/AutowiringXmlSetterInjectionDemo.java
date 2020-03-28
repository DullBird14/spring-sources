package org.geek.ioc.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * xml方式手动依赖注入
 * @author cys
 * @date 2020-03-07 22:01
 */

public class AutowiringXmlSetterInjectionDemo {
	public static void main(String[] args) {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

		reader.loadBeanDefinitions("classpath:/beans/autowiring-userHolder-bean-lookup-injection.xml");

		UserHolder bean = beanFactory.getBean(UserHolder.class);
		System.out.println(bean);

	}
}
