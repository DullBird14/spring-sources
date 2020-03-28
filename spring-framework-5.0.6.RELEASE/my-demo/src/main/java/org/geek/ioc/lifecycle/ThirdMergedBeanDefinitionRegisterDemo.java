package org.geek.ioc.lifecycle;

import org.geek.ioc.overview.dependent.domain.SuperUser;
import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * BeanDefinition 的合并
 * @author dullBird
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月15日 21:14:00
 * @see DefaultListableBeanFactory#getMergedBeanDefinition(String) 
 */
public class ThirdMergedBeanDefinitionRegisterDemo {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		// 需要一个 beanFactoryRegistry
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		int i = reader.loadBeanDefinitions("classpath:/META-INF/lifecycle-bean.xml");
		System.out.println(i);
		User user = factory.getBean("user", User.class);
		System.out.println(user);
		SuperUser superUser = factory.getBean("superUser", SuperUser.class);
		System.out.println(superUser);
	}
}
