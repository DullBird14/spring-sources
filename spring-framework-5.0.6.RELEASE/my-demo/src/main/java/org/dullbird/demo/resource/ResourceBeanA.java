package org.dullbird.demo.resource;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author cys
 * @date 2019-12-30 20:04
 */
//@Data
@Component
public class ResourceBeanA {
	private ResourceBeanB beanB;

	@Resource
	public void setBeanB(ResourceBeanB beanB) {
		this.beanB = beanB;
	}

	public void say(){
		System.out.println("===========I am ResourceBeanA========");
		System.out.println(beanB);
	}

}
