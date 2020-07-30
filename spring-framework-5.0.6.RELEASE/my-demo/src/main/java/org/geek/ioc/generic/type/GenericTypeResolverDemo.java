package org.geek.ioc.generic.type;

import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月28日 23:14:00
 */
public class GenericTypeResolverDemo {
	public static void main(String[] args) throws NoSuchMethodException {

		Method test = GenericTypeResolverDemo.class.getMethod("test", null);
		// 获取具体的返回类型
		Class<?> aClass = GenericTypeResolver.resolveReturnType(test, GenericTypeResolverDemo.class);
		System.out.println(aClass);

		Method testA = GenericTypeResolverDemo.class.getMethod("testA", null);
		// 获取具体的返回类型
		Class<?> aClassA = GenericTypeResolver.resolveReturnType(testA, GenericTypeResolverDemo.class);
		System.out.println(aClassA);
		// 获取输入参数的类型
		Method withParameter = GenericTypeResolverDemo.class.getMethod("withParameter", String.class);
		Class<?>[] parameterTypes = withParameter.getParameterTypes();
		Stream.of(parameterTypes).forEach(System.out::println);


		Method getGenericList = GenericTypeResolverDemo.class.getMethod("getGenericList", null);
		// 获取 raw type
		Class<?> rawType = GenericTypeResolver.resolveReturnType(getGenericList, GenericTypeResolverDemo.class);
		System.out.println(rawType);
		// 获取泛型的具体化对象
		Class<?> aClass1 = GenericTypeResolver.resolveReturnTypeArgument(getGenericList, List.class);
		System.out.println(aClass1);

	}

	public static String test() {
		return null;
	}

	/**
	 * 其中的 E 为非具体化的泛型
	 **/
	public static <E> E testA() {
		return null;
	}


	public static <E> E withParameter(String A) {
		return null;
	}

	public static ArrayList<String> getGenericList() {
		return null;
	}
}


