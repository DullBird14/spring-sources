package org.geek.ioc.dependency.source;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 单例注入的对象。 依赖查找和依赖注入都可以
 * 1. 生命周期不归spring管理
 * 2. 不能做延迟加载
 * @author dullBird
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月14日 17:50:00
 */
public class RegisterSingletonSourceDemo {
	@Autowired(required = false)
	private String injectString;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(RegisterSingletonSourceDemo.class);
		/**
		 * 解决下面的todo问题
		 */
		applicationContext.addBeanFactoryPostProcessor((beanFactory -> {
			beanFactory.registerSingleton("test", "hahah" );
		}));
		// 启动spring上下文
		applicationContext.refresh();
		RegisterSingletonSourceDemo demo = applicationContext.getBean(RegisterSingletonSourceDemo.class);
		/**
		 * todo
		 * 如果代码按照注释这样去写的话。会发现依赖注入的时候没有。但是依赖查找的时候有
		 * 原因是 1。context 先触发了refresh()，创建了对象 RegisterSingletonSourceDemo，此时上下文并没有 String 的bean，所以为null
		 * 2. 等context refresh之后。我们才注入了 String 的bean
		 * 这里需要使用
		 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor
		 * lookup bean :hahah
		 * inject bean :null
		 */
//		ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
//		beanFactory.registerSingleton("test", "hahah" );
		String lookUpString = applicationContext.getBean(String.class);
		// 依赖查找和注入都可以找到
		System.out.println("lookup bean :" + lookUpString);
		System.out.println("inject bean :" + demo.injectString);
		/**
		 * lookup bean :hahah
		 * inject bean :hahah
		 */
		// 关闭spring上下文
		applicationContext.close();
	}
}
