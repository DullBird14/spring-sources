package org.geek.aop.aspecj;

import org.geek.aop.aspecj.config.HelloAdviceMethodInterceptor;
import org.geek.aop.aspecj.pointcut.HelloPointcut;
import org.geek.aop.aspecj.origin.DefaultHelloImpl;
import org.geek.aop.aspecj.origin.HelloInterface;
import org.geek.aop.aspecj.pointcut.MyPointcut;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;

public class AspectJApiDemo {
	public static void main(String[] args) {
		test3();
//		test2();
//		test1();
	}

	private static void test3() {
		DefaultHelloImpl defaultHello = new DefaultHelloImpl();
		//proxy代理
		ProxyFactory proxyFactory = new ProxyFactory(defaultHello);
		proxyFactory.addAdvice(new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {

			}
		});
	}

	private static void test2() {
		DefaultHelloImpl defaultHello = new DefaultHelloImpl();
		//proxy代理
		ProxyFactory proxyFactory = new ProxyFactory(defaultHello);
		//advice
		HelloAdviceMethodInterceptor methodInterceptor = new HelloAdviceMethodInterceptor();
		// pointcut + advice = advisor
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(new MyPointcut(), methodInterceptor);
		proxyFactory.addAdvisor(advisor);
		HelloInterface proxy = (HelloInterface)proxyFactory.getProxy();
		proxy.hello();
	}

	private static void test1() {
		DefaultHelloImpl defaultHello = new DefaultHelloImpl();
		//proxy代理
		ProxyFactory proxyFactory = new ProxyFactory(defaultHello);
		//advice
		HelloAdviceMethodInterceptor methodInterceptor = new HelloAdviceMethodInterceptor();
		// pointcut + advice = advisor
		DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor(new HelloPointcut(), methodInterceptor);
		proxyFactory.addAdvisor(advisor);
		HelloInterface proxy = (HelloInterface)proxyFactory.getProxy();
		proxy.hello();
	}
}
