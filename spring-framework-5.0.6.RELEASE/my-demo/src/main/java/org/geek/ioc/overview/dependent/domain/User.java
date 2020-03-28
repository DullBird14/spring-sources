package org.geek.ioc.overview.dependent.domain;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author cys
 * @date 2020-01-05 11:14
 */
@Component
public class User implements InitializingBean {
	private int id;
	private String name;

	public User() {
	}

	public User(int id) {
		this.id = id;
	}

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public static User createUser() {
		return new User(1, "静态方法创建");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("==============User afterPropertiesSet =======");
		if (id == 0) {
			id =1;
			name = "cys-one";
		}
	}
}
