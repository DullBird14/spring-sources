package org.geek.ioc.environment;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月19日 23:31:00
 */
@SpringBootApplication
public class YmlConfigurationBootDemo implements ApplicationContextAware {

	public static void main(String[] args) {
		SpringApplication.run(YmlConfigurationBootDemo.class);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ConfigurableApplicationContext context = (ConfigurableApplicationContext) applicationContext;
		context.getEnvironment().getPropertySources().forEach(System.out::println);
	}
}
