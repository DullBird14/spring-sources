package org.geek.ioc.dependency.injection;

import org.geek.ioc.dependency.injection.annotation.SelfGroupQualifier;
import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

/**
 * Qualifier 的限定注入
 * @author cys
 * @date 2020-03-07 22:01
 */

public class QualifierAnnotationInjectionResulationDemo {
	@Autowired
	private User user;

	@Autowired
	@Qualifier("superUser")
	private User superUser;
	/**
	 * 其中 allUser 会注入所有没有 Qualifier 的User
	 */
	@Autowired
	private Collection<User> allUser;
	/**
	 * 其中 qualifierUser 会注入所有标记了 Qualifier 及其子注解，比如 {@link SelfGroupQualifier} 的User
	 */
	@Autowired
	@Qualifier
	private Collection<User> qualifierUser;

	@Autowired
	@SelfGroupQualifier
	// 注入指定子注解的分组
	private Collection<User> selfQualifierUser;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 注入xml情况下的bean
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
		reader.loadBeanDefinitions("classpath:/beans/bean-lookup-injection.xml");
		context.register(QualifierAnnotationInjectionResulationDemo.class);
		context.refresh();

		QualifierAnnotationInjectionResulationDemo demo = context.getBean(QualifierAnnotationInjectionResulationDemo.class);
		// 不带 Qualifier
		System.out.println(demo.user);
		// 通过 Qualifier 指定
		System.out.println(demo.superUser);
		// 是superUser 和user
		System.out.println(demo.allUser);
		// 是标注了 @Qualifier 的user
		System.out.println(demo.qualifierUser);
		System.out.println(demo.selfQualifierUser);
		context.close();
	}

	@Bean
	@Qualifier
	public User user1(){
		return createUser(7);
	}

	@Bean
	@Qualifier
	public User user2(){
		return createUser(8);
	}

	@Bean
	@SelfGroupQualifier
	public User user3(){
		return createUser(9);
	}
	private static User createUser(int id){
		return new User(id);
	}

}
