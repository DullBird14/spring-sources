package org.geek.ioc.overview.dependent.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author cys
 * @date 2020-03-02 22:09
 */

public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {
	@PostConstruct
	public void postConstruct(){
		System.out.println("============ PostConstruct ============");
	}

	public void beanInit(){
		System.out.println("============ beanInit ============");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("============ afterPropertiesSet ============");

	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("============ preDestroy ============");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("============ DisposableBean ============");
	}

	public void selfDestroy(){
		System.out.println("============ selfDestroy ============");
	}

}
