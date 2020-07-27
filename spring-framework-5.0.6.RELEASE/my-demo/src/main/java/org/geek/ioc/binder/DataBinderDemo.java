package org.geek.ioc.binder;

import org.geek.ioc.binder.pojo.BinderObject;
import org.geek.ioc.binder.pojo.BinderSubObject;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月20日 19:29:00
 */
public class DataBinderDemo {
	public static void main(String[] args) {
		BinderObject object = new BinderObject();
		DataBinder dataBinder = new DataBinder(object, "binder");
		MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
//		mutablePropertyValues.add("name", "dullbird");
//		mutablePropertyValues.add("age", "10");
//		mutablePropertyValues.add("time", "10");
		mutablePropertyValues.add("subObject.address", "hz.yh");

//		//1. 设置某些字段不被覆盖值
//		dataBinder.setAllowedFields("name");

//		//2. 设置不支持嵌套路径对象的创建，本来没有对象会new一个，设置之后不会创建,直接报错
//		//手动创建
//		object.setSubObject(new BinderSubObject());
//		dataBinder.setAutoGrowNestedPaths(false);

//		//3. 设置不忽略未知属性。比如 time 这个属性 DataBinder 中是没有的，就会报错
//		dataBinder.setIgnoreUnknownFields(false);

//		//4. 设置属性必须存在,
//		dataBinder.setRequiredFields("ename");
//		dataBinder.bind(mutablePropertyValues);
//		//不会有报错，但是保存在 BindingResult
//		BindingResult bindingResult = dataBinder.getBindingResult();
//		System.out.println(bindingResult);

		dataBinder.bind(mutablePropertyValues);
		System.out.println(object);
	}
}
