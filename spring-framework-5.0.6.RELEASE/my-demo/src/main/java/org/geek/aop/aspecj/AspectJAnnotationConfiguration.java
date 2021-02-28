package org.geek.aop.aspecj;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.geek.aop.aspecj.origin.DefaultHelloImpl;
import org.geek.aop.aspecj.origin.HelloInterface;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@Aspect
@EnableAspectJAutoProxy
public class AspectJAnnotationConfiguration {
	@Pointcut("execution(* org.geek.aop.aspecj.origin.HelloInterface.*(..))")
	private void find() { };

	@Before(value = "find()")
	public void before() {
		System.out.println("111111111111");
	}

	@Bean
	public HelloInterface createHello() {
		return new DefaultHelloImpl();
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AspectJAnnotationConfiguration.class);
		context.refresh();
		HelloInterface bean = context.getBean(HelloInterface.class);
		bean.hello();
		context.close();
	}
}
