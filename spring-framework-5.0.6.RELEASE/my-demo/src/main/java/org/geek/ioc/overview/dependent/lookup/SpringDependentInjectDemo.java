package org.geek.ioc.overview.dependent.lookup;

import org.geek.ioc.overview.dependent.config.MainConfiguration;
import org.geek.ioc.overview.dependent.domain.UserManager;
import org.geek.ioc.overview.dependent.domain.UserObjectFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author cys
 * @date 2020-01-05 11:14
 */

public class SpringDependentInjectDemo {
	public static void main(String[] args) {
		BeanFactory beanFactory = new AnnotationConfigApplicationContext(MainConfiguration.class);
//		injectByNameAndType(beanFactory);
		innerBeanTest(beanFactory);
	}

	private static void innerBeanTest(BeanFactory beanFactory) {
		//依赖查找,spring的内建非bean
		//NoSuchBeanDefinitionException: No qualifying bean of type 'org.springframework.beans.factory.BeanFactory' available
//		BeanFactory bean = beanFactory.getBean(BeanFactory.class);
		UserObjectFactory beanFactoryBean = beanFactory.getBean(UserObjectFactory.class);
		BeanFactory injectBeanFactory = beanFactoryBean.getBeanFactory();
//		System.out.println(bean);
		// 存在
		System.out.println(injectBeanFactory);
		// 但是不相等。 DefaultListableBeanFactory
		System.out.println(injectBeanFactory == beanFactory);
		//AnnotationConfigApplicationContext
		System.out.println(beanFactory);

	}

	private static void injectByNameAndType(BeanFactory beanFactory) {
		UserManager bean = beanFactory.getBean(UserManager.class);
		//@Autowired -> UserManager{list=[SuperUser{address='abc street'} User{id=2, name='cys-super'}, User{id=1, name='cys-one'}]}
		//@Autowired + @Qualifier("user") -> UserManager{list=[User{id=1, name='cys-one'}]}
		System.out.println(bean);
	}


}
