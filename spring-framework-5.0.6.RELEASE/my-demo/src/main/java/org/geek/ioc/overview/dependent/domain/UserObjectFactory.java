package org.geek.ioc.overview.dependent.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cys
 * @date 2020-01-05 11:20
 */
@Component
public class UserObjectFactory implements ObjectFactory<User> {
	@Autowired
	private BeanFactory beanFactory;

	@Autowired
	private User user;

	@Override
	public User getObject() throws BeansException {
		return user;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
