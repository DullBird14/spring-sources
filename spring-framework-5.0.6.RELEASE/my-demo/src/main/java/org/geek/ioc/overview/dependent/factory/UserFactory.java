package org.geek.ioc.overview.dependent.factory;

import org.geek.ioc.overview.dependent.domain.User;

/**
 * @author cys
 * @date 2020-03-02 22:08
 */

public interface UserFactory {
	default User getUser() {
		return User.createUser();
	}
}
