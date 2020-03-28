package org.geek.ioc.dependency.injection;

import org.geek.ioc.overview.dependent.domain.User;

/**
 * @author cys
 * @date 2020-03-07 22:03
 */

public class UserHolder {
	private User user;

	public UserHolder(User user) {
		this.user = user;
	}

	public UserHolder() {
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserHolder{" +
				"user=" + user +
				'}';
	}
}
