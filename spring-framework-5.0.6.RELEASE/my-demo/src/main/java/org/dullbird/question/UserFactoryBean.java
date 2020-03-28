package org.dullbird.question;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.FactoryBean;

import java.util.Objects;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年03月26日 23:42:00
 */
public class UserFactoryBean implements FactoryBean {

	private User user;
	@Override
	public String getObject() throws Exception {
		if (Objects.isNull(user)) {
			System.out.println("=========user is null===========");
			return "abc";
		}
		return "def";
	}

	@Override
	public Class<?> getObjectType() {
		return user.getClass();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
