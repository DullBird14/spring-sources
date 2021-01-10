package org.geek.aop.aspecj;

import org.geek.aop.aspecj.config.HelloAdviceMethodInterceptor;
import org.geek.aop.aspecj.config.HelloPointcut;
import org.geek.aop.aspecj.origin.DefaultHelloImpl;
import org.geek.aop.aspecj.origin.HelloInterface;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectJApiDemo {
	public static void main(String[] args) {
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
