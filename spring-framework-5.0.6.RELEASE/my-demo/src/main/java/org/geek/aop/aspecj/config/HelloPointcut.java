package org.geek.aop.aspecj.config;

import org.geek.aop.aspecj.origin.HelloInterface;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class HelloPointcut extends StaticMethodMatcherPointcut {
	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		if (HelloInterface.class.isAssignableFrom(targetClass)
				&& "hello".equals(method.getName())) {
			return true;
		}
		return false;
	}
}
