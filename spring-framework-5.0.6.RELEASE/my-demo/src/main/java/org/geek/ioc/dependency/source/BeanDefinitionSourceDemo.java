package org.geek.ioc.dependency.source;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring BeanDefinition 依赖来源
 * 1. 依赖查找和依赖注入都可以查找到
 * @see  BeanDefinitionRegistry#registerBeanDefinition
 * @author cys
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月14日 17:09:00
 */
public class BeanDefinitionSourceDemo {
	@Autowired
	private User user;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(BeanDefinitionSourceDemo.class);
		// beandifinition 需要在refresh之前注册，否则没有用
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
		applicationContext.registerBeanDefinition("user", builder.getBeanDefinition());
		builder.addPropertyValue("name", "haha");
		builder.addPropertyValue("id", "1");

		// 启动spring上下文
		applicationContext.refresh();
		User user = applicationContext.getBean("user", User.class);

		BeanDefinitionSourceDemo demo = applicationContext.getBean(BeanDefinitionSourceDemo.class);
		// 依赖查找和注入都可以找到
		System.out.println("lookup bean :" + user);
		System.out.println("inject bean :" + demo.user);
		/**
		 * ==============User afterPropertiesSet =======
		 * lookup bean :User{id=1, name='haha'}
		 * inject bean :User{id=1, name='haha'}
		 */
		// 关闭spring上下文
		applicationContext.close();
	}
}
