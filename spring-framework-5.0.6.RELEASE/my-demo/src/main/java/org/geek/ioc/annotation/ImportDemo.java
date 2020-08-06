package org.geek.ioc.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.context.support.GenericApplicationContext;

/**
 * {@link Import}
 * 1. configuration class
 * 2. selector 实现
 * 3. ImportBeanDefinitionRegistrar
 *
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月06日 22:04:00
 */
//@Import(ImportConfiguration.class) 	// 第一种方式
//@Import(ImportIntegerSelector.class) 	// 第二种方式
//@Import(ImportIntegerRegister.class) 	// 第三种方式
public class ImportDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ImportDemo.class);
		context.refresh();
		Integer integer = context.getBean(Integer.class);
		System.out.println(integer);
		context.close();
	}
}
