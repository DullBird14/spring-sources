package org.dullbird.demo.bean;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author cys
 * @date 2019-12-22 22:40
 */
@Component
public class TestUser implements EnvironmentAware {
	private String name ;
	private int age;
	/**
	 * 测试AutowiredAnnotationBeanPostProcessor
	 */
	private Environment environment;

	@Override
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Environment getEnvironment() {
		return environment;
	}

	@Override
	public String toString() {
		return "";
	}
}
