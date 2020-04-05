package org.geek.ioc.metadata.ioc;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.Map;

/**
 * 基于 xml 的外部化配置例子
 *
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月05日 16:00:00
 */
@PropertySource(name = "my-yaml-source", value = "classpath:/META-INF/user.yml", factory = YamlPropertySourceFactory.class)
public class AnnotationBaseYamlConfigurationDemo {
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
		context.register(AnnotationBaseYamlConfigurationDemo.class);
		// spring 上下文启动
		context.refresh();

//		User bean = context.getBean(User.class);
//		System.out.println(bean);
		MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
		System.out.println(propertySources);

		// spring 上下文关闭
		context.close();
	}
}
