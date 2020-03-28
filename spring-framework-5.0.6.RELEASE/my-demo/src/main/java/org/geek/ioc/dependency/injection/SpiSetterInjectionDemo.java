package org.geek.ioc.dependency.injection;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * xml方式手动依赖注入
 * @author cys
 * @date 2020-03-07 22:01
 */

public class SpiSetterInjectionDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.registerBeanDefinition("userHolder", createUserHolderBeanDefinition());
		// 注入xml情况下的bean
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
		reader.loadBeanDefinitions("classpath:/beans/bean-lookup-injection.xml");
		context.refresh();

		UserHolder bean = context.getBean(UserHolder.class);
		System.out.println(bean);

		context.close();
	}

	private static BeanDefinition createUserHolderBeanDefinition(){
		BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
		beanDefinitionBuilder.addPropertyReference("user", "superUser");
		return beanDefinitionBuilder.getBeanDefinition();
	}
}
