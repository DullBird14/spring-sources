package org.geek.ioc.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

/**
 * 注册 {@link ApplicationListener}
 * 1. ConfigurableApplicationContext api 的注册方式
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月01日 11:55:00
 * @see ConfigurableApplicationContext
 */
public class ApplicationListenerDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ApplicationListenerDemo.class);
		//利用 api 的方式注册
		context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
			@Override
			public void onApplicationEvent(ApplicationEvent event) {
				System.out.printf("api方式:[%s thread: 事件:%s]\n", Thread.currentThread().getName(),
						event.getClass().getName());
			}
		});
		//利用 api 的方式注册指定事件类型
		context.addApplicationListener(new ApplicationListener<ContextRefreshedEvent>() {
			@Override
			public void onApplicationEvent(ContextRefreshedEvent event) {
				System.out.printf("api方式:[%s thread: 指定事件:%s]\n", Thread.currentThread().getName(),
						event.getClass().getName());
			}
		});
		context.refresh();
		context.close();
	}

	/**
	 * 注解方式 注册 EventListener
	 * @param event
	 */
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.printf("注解方式:[%s thread: 事件:%s]\n", Thread.currentThread().getName(),
				event.getClass().getName());
	}
}
