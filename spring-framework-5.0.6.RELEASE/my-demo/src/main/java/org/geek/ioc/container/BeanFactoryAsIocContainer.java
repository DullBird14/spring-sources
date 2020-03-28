package org.geek.ioc.container;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author cys
 * @date 2020-01-10 12:54
 */

public class BeanFactoryAsIocContainer {
	public static void main(String[] args) {
		DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();

		BeanFactory beanFactory = new DefaultListableBeanFactory();
		User bean = beanFactory.getBean(User.class);
		System.out.println(bean);
	}
}
