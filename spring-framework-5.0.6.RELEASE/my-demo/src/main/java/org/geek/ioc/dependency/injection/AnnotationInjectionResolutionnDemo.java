package org.geek.ioc.dependency.injection;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AutowireCandidateResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Optional;

/**
 * 注解形式主动注入
 * @see org.springframework.beans.factory.support.DefaultListableBeanFactory
 * @see org.springframework.beans.factory.config.DependencyDescriptor
 * @see AutowireCandidateResolver
 *
 * @author cys
 * @date 2020-03-07 22:01
 */

public class AnnotationInjectionResolutionnDemo {

	/**
	 *  required = true
	 *  declaringClass = AnnotationInjectionResolutionnDemo
	 *  fieldName = user
	 *  eager = true
	 *  记录一种场景。当user,和superUser 都没有标记primary的时候，
	 *  这个时候根据类型会找到两个User[user、superUser]，会注入和属性名称一样的bean,
	 *  即user,如果没有的话。直接报错
	 */
	@Autowired
	private User user;
	/**
	 * 返回前包装了一层Optional
	 * // 获取依赖类型是取出范形中的具体类型
	 * ((ParameterizedType) type).getActualTypeArguments()
	 */
//	@Autowired
//	private Optional<User> optionalUser;
//
//	@Autowired
//	private Map<String, User> userMap;
//
//	@Autowired
//	@Lazy
//	private User lazyUser;
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 注入xml情况下的bean
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
		reader.loadBeanDefinitions("classpath:/beans/bean-lookup-injection.xml");
		context.register(AnnotationInjectionResolutionnDemo.class);
		context.refresh();

		AnnotationInjectionResolutionnDemo demo = context.getBean(AnnotationInjectionResolutionnDemo.class);
		context.close();
	}


}
