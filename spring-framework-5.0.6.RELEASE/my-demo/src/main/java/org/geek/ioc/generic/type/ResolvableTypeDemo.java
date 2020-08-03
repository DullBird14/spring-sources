package org.geek.ioc.generic.type;

import org.springframework.core.ResolvableType;

import java.util.stream.Stream;

/**
 * @{link ResolvableType}
 * 通用个的类型处理方法
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月30日 07:50:00
 */
public class ResolvableTypeDemo {
	public static void main(String[] args) {
		ResolvableType[] generics = ResolvableType.forClass(GenericStringList.class).getGenerics();
		Stream.of(generics).forEach(System.out::println);
		Class<?> resolve = ResolvableType.forClass(GenericStringList.class).resolve();
		System.out.println(resolve);

		ResolvableType resolvableType = ResolvableType.forClass(GenericStringList.class);
		System.out.println(resolvableType);
		System.out.println(resolvableType.getGeneric(0));
		System.out.println(resolvableType.getSuperType());
		System.out.println(resolvableType.getSuperType().getGeneric(0));
	}

}
