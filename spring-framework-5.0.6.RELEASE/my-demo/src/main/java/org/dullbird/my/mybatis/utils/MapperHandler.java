package org.dullbird.my.mybatis.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author cys
 * @date 2020-01-17 23:46
 */

public class MapperHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Select annotation = method.getAnnotation(Select.class);
		String sql = annotation.sql();
		System.out.println("绑定sql" + sql +" 参数如下:" + Arrays.toString(args));
		System.out.println("创建数据库链接");
		System.out.println("执行sql");
		System.out.println("返回结果");
		return 0;
	}
}
