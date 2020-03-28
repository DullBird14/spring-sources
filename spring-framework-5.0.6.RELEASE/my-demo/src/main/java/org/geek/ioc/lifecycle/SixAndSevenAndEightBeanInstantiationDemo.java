package org.geek.ioc.lifecycle;

import org.geek.ioc.overview.dependent.domain.SuperUser;
import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.*;

import java.beans.PropertyDescriptor;
import java.util.Objects;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年03月16日 22:50:00
 */
@Configuration
public class SixAndSevenAndEightBeanInstantiationDemo {
//	@Bean
//	public User user(){
//		return new User();
//	}
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//		AnnotatedBeanDefinitionReader annotatedReader = new AnnotatedBeanDefinitionReader(factory);
//		annotatedReader.registerBean(SixBeanInstantiationDemo.class);
//		annotatedReader.register(SixBeanInstantiationDemo.class);
		factory.addBeanPostProcessor(new InstantiationAwareBeanPostProcessor() {
			@Override
			public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
				if ("user".equals(beanName)
						&& bean instanceof User) {
					User cast = User.class.cast(bean);
					cast.setId(-1);
					return false;
				}
				return true;
			}

			@Override
			public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds,
															Object bean, String beanName) throws BeansException {
				if ("superUser".equals(beanName)
						&& bean instanceof SuperUser) {
					MutablePropertyValues propertyValues = new MutablePropertyValues(pvs);
					propertyValues.add("tag", "测试");
					return propertyValues;
				}
				return null;
			}
		});
//		// 需要一个 beanFactoryRegistry
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		int i = reader.loadBeanDefinitions("classpath:/META-INF/lifecycle-bean.xml");
//		System.out.println(i);
		User user = factory.getBean("user", User.class);
		System.out.println(user);
		SuperUser superUser = factory.getBean("superUser", SuperUser.class);
		System.out.println(superUser);
	}
}

