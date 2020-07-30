package org.geek.ioc.generic.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月28日 23:01:00
 */
public class TypeDemo {
	public static void main(String[] args) {
		// 原生类型
		Class intType = int.class;
		// arrayType
		Class arrayType = Object[].class;
		// 原始类型
		Class rawClass = String.class;

		// 泛型参数类型
		ParameterizedType genericSuperclass = (ParameterizedType) ArrayList.class.getGenericSuperclass();
		System.out.println(genericSuperclass);

		// 原始类型
		System.out.println(genericSuperclass.getRawType());
		// 参数类型
		Stream.of(genericSuperclass.getActualTypeArguments()).forEach(System.out::println);
	}
}
