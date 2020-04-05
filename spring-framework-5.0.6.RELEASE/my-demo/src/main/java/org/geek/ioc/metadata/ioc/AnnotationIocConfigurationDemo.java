package org.geek.ioc.metadata.ioc;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.MutablePropertySources;

import java.util.Map;

/**
 * 基于 xml 的外部化配置例子
 *
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月05日 16:00:00
 */
@ImportResource("classpath:/META-INF/metadata-annotation-demo.xml")
@Import(User.class)
@PropertySource("classpath:/META-INF/user.properties")
@PropertySource("classpath:/META-INF/user.properties")
public class AnnotationIocConfigurationDemo {
	/**
	 *  此处的注入
	 * @param id
	 * @param name
	 * @return
	 */
	@Bean
	public User myUser(@Value("${user.id}") Integer id, @Value("${user.name}") String name) {
		return 	new User(id, name);
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AnnotationIocConfigurationDemo.class);
		// spring 上下文启动
		context.refresh();

		Map<String, User> beansOfType = context.getBeansOfType(User.class);
		for (Map.Entry<String, User> stringUserEntry : beansOfType.entrySet()) {
			System.out.printf("current bean-name:%s  user-info:%s\n", stringUserEntry.getKey(), stringUserEntry.getValue());
		}
		MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
		System.out.println(propertySources);

		// spring 上下文关闭
		context.close();
	}
}
