package org.geek.aop.aspecj.advisor;


import org.geek.aop.aspecj.origin.HelloInterface;
import org.springframework.aop.IntroductionInfo;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultIntroductionAdvisor;

import java.lang.reflect.Method;
import java.util.Map;

public class IntroductionAdvisorDemo implements HelloInterface, Comparable<String> {
	public static void main(String[] args) {
		IntroductionAdvisorDemo target = new IntroductionAdvisorDemo();
		// 如果用这个构造方法。一开始就往 ProxyFactory 中设置了 HelloInterface, Comparable<String>
//		ProxyFactory proxyFactory = new ProxyFactory(target);
		// 这种方式没有设置接口
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvisor(new DefaultIntroductionAdvisor(new MethodBeforeAdvice() {
			@Override
			public void before(Method method, Object[] args, Object target) throws Throwable {
				System.out.printf("DefaultIntroductionAdvisor:method:%s\n", method.toString());
			}
		}, new IntroductionInfo() {
			@Override
			public Class<?>[] getInterfaces() {
				// 可以增减接口
				return new Class[]{HelloInterface.class, Map.class};
			}
		}));

		Object proxy = proxyFactory.getProxy();
		HelloInterface helloInterface = (HelloInterface) proxy;
		helloInterface.hello();
//		Comparable comparable = (Comparable) proxy;
//		comparable.compareTo(null);


		Map map = (Map) proxy;
		map.put("1",1);

	}

	@Override
	public int compareTo(String o) {
		return 0;
	}

	@Override
	public void hello() {
		System.out.println("IntroductionAdvisorDemo:!!!!");
	}
}
