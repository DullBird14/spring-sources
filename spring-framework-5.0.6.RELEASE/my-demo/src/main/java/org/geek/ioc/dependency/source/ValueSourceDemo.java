package org.geek.ioc.dependency.source;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * 外部化配置 比如 @Value 其注入的不是bean,就是配置值
 * @author dullBird
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月14日 18:06:00
 */
@Configuration
@PropertySource("classpath:/META-INF/user.properties")
public class ValueSourceDemo {
	@Value("${user.id:-1}")
	private Long id;
	@Value("${user.name}")
	private String name;
	@Value("${user.path:/test}")
	private Resource resource;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(ValueSourceDemo.class);

		// 启动spring上下文
		applicationContext.refresh();

		ValueSourceDemo demo = applicationContext.getBean(ValueSourceDemo.class);
		// 依赖查找和注入都可以找到
		System.out.println("id :" + demo.id);
		System.out.println("name :" + demo.name);
		System.out.println("resource :" + demo.resource);
		/**
		 * 这里的name 不是 hahah 的原因是配置有优先级。会优先选择系统的配置属性
		 * 系统的配置 user.name = user01
		 * id :100
		 * name :user01
		 * resource :class path resource [META-INF/user.properties]
		 */

		// 关闭spring上下文
		applicationContext.close();
	}
}
