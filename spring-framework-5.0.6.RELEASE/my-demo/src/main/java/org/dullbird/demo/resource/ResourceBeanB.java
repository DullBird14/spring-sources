package org.dullbird.demo.resource;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author cys
 * @date 2019-12-30 20:04
 */
@Component
public class ResourceBeanB {
	@Resource
	private ResourceBeanA beanA;

	public void say(){
		System.out.println("===========I am ResourceBeanB========");
		System.out.println(beanA);
	}

}
