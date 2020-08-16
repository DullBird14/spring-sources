package org.geek.ioc.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月12日 23:25:00
 */
@Import(EnvironmentAwareDemo.class)
public class ContextRefreshDemo {
	@Autowired(required = false)
	@Qualifier("org.geek.ioc.context.EnvironmentAwareDemo")
	private EnvironmentAware environmentAware;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ContextRefreshDemo.class);

		context.refresh();

		EnvironmentAware bean = context.getBean("org.geek.ioc.context.EnvironmentAwareDemo", EnvironmentAware.class);
		System.out.printf("dependency find: %s\n", bean);

		ContextRefreshDemo contextBean = context.getBean(ContextRefreshDemo.class);
		System.out.printf("dependency inject: %s\n", contextBean.environmentAware);

		context.close();
	}

}
