package org.geek.ioc.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月01日 23:39:00
 */
public class HierarchicalPublisherDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext currentContext = new AnnotationConfigApplicationContext();
		AnnotationConfigApplicationContext parentContext = new AnnotationConfigApplicationContext();
		currentContext.addApplicationListener(getApplicationEventApplicationListener());
		parentContext.addApplicationListener(getApplicationEventApplicationListener());
		currentContext.setParent(parentContext);
		parentContext.refresh();
		currentContext.refresh();
		// 子的会传递到父亲那里
		currentContext.publishEvent("hello, i'm current!");
		// 父的不会传递到子的那里
		parentContext.publishEvent("hello, i'm parent!");

		parentContext.close();
		currentContext.close();
	}

	private static ApplicationListener<PayloadApplicationEvent<String>> getApplicationEventApplicationListener() {
		return event -> System.out.printf("api方式:[%s thread: 事件:%s source:%s]\n", Thread.currentThread().getName(),
				event.getClass().getName(), event.getPayload());
	}
}
