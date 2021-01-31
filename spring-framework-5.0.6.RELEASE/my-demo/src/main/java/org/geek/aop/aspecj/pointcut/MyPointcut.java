package org.geek.aop.aspecj.pointcut;

import org.geek.aop.aspecj.origin.HelloInterface;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

import java.lang.reflect.Method;

public class MyPointcut implements Pointcut {
	@Override
	public ClassFilter getClassFilter() {
		return new ClassFilter() {
			@Override
			public boolean matches(Class<?> clazz) {
				return HelloInterface.class.isAssignableFrom(clazz);
			}
		};
	}

	@Override
	public MethodMatcher getMethodMatcher() {
		return new MethodMatcher() {
			@Override
			public boolean matches(Method method, Class<?> targetClass) {
				return "hello".equals(method.getName());
			}

			@Override
			public boolean isRuntime() {
				return false;
			}

			@Override
			public boolean matches(Method method, Class<?> targetClass, Object... args) {
				return false;
			}
		};
	}
}
