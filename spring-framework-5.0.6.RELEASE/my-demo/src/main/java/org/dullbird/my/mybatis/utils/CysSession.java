package org.dullbird.my.mybatis.utils;

import java.lang.reflect.Proxy;

/**
 * @author cys
 * @date 2020-01-18 11:45
 */
public class CysSession {
	public static Object getMapper(Class clazz) {
		return Proxy.newProxyInstance(clazz.getClassLoader(),
				new Class[]{clazz}, new MapperHandler());
	}
}
