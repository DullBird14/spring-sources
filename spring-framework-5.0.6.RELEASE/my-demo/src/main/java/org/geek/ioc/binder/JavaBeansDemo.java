package org.geek.ioc.binder;

import org.geek.ioc.binder.pojo.BinderObject;

import java.beans.*;
import java.util.Arrays;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月27日 10:04:00
 */
public class JavaBeansDemo {
	public static void main(String[] args) throws IntrospectionException {
		//1. 利用 Introspector 获取 BeanInfo
		BeanInfo beanInfo = Introspector.getBeanInfo(BinderObject.class);
		//2. BeanDescriptor
		System.out.printf("=================%s===================\n", "BeanDescriptor");
		BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
		System.out.println(beanDescriptor);
		//3. PropertyDescriptor[]
		System.out.printf("=================%s===================\n", "PropertyDescriptor[]");
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		Arrays.stream(propertyDescriptors).forEach(System.out::println);
		//4.MethodDescriptor[]
		System.out.printf("=================%s===================\n", "MethodDescriptor[]");
		MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
		Arrays.stream(methodDescriptors).forEach(System.out::println);

	}
}
