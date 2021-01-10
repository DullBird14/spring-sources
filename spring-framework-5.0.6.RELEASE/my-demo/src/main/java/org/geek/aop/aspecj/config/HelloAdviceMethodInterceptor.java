package org.geek.aop.aspecj.config;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class HelloAdviceMethodInterceptor implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("HelloAdviceMethodInterceptor:filter worked!");
		return invocation.proceed();
	}
}
