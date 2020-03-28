package org.geek.ioc.overview.dependent.factory;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author cys
 * @date 2020-03-02 22:34
 */

public class UserFactoryBean implements FactoryBean {
	@Override
	public Object getObject() throws Exception {
		return User.createUser();
	}

	@Override
	public Class<?> getObjectType() {
		return User.class;
	}
}
