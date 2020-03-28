package org.geek.ioc.lifecycle;

import org.geek.ioc.overview.dependent.domain.SuperUser;
import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Objects;

/**
 * bean初始化之前的操作,提供一个拦截点，可以绕过spring的初始化。如果返回了对象。后面将不再执行
 * InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation
 *
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年03月15日 23:21:00
 * @see InstantiationAwareBeanPostProcessor#postProcessBeforeInstantiation
 */
public class FiveBeforeBeanInstantiationDemo {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {

			@Override
			public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
				if ("user".equals(beanName)
						&& beanClass.isAssignableFrom(User.class) ) {
					User user = User.createUser();
					user.setId(-1);
					user.setName("BeforeInstantiation");
					return user;
				}
				return null;
			}
		});
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
