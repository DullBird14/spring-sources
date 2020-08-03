package org.geek.ioc.event;

import org.springframework.beans.BeansException;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.PostConstruct;

/**
 * 获取 {@link ApplicationEventPublisher}
 * <p>
 * 1. {@link ApplicationEventPublisherAware}
 * 2. @Autowire
 *
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月01日 23:22:00
 * @see ApplicationEventPublisher
 * @see ApplicationEventPublisherAware
 */
public class ApplicationEventPublisherDemo implements ApplicationEventPublisherAware,
		ApplicationContextAware {
	private ApplicationEventPublisher publisher;
	private ApplicationContext context;

	@PostConstruct
	//	不能用PostConstruct，因为 @EventListener的处理在其之后
	// 但是 api的方式可以监听到事件
	public void publish() {
		context.publishEvent(new ApplicationEvent("hello, context event!") {
			@Override
			public Object getSource() {
				return super.getSource();
			}
		});

		publisher.publishEvent(new ApplicationEvent("hello, publisher event!") {
			@Override
			public Object getSource() {
				return super.getSource();
			}
		});
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 测试 api方式注册 EventListener 和 @EventListener 的结果不一样
		context.addApplicationListener(event -> System.out.printf("api方式:[%s thread: 事件:%s source:%s]\n", Thread.currentThread().getName(),
				event.getClass().getName(), event.getSource()));
		context.register(ApplicationEventPublisherDemo.class);
		context.refresh();
//		ApplicationEventPublisherDemo bean = context.getBean(ApplicationEventPublisherDemo.class);
//		bean.publish();
		context.close();
	}


//	@EventListener
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.printf("注解方式:[%s thread: 事件:%s source:%s]\n", Thread.currentThread().getName(),
				event.getClass().getName(), event.getSource());
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.context = applicationContext;
	}
}
