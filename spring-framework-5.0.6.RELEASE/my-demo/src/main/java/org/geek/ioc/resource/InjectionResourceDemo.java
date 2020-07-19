package org.geek.ioc.resource;

import org.geek.ioc.resource.util.ResourceUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.stream.Stream;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月18日 22:18:00
 */
public class InjectionResourceDemo {
	@Value("classpath:/msg/message.properties")
	private Resource resource;
	@Value("classpath:/msg/*.properties")
	private Resource[] resources;
	/**
	 * List的方式无法加载
	 */
	@Value("classpath:/msg/*.properties")
	private List<Resource> resourceList;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InjectionResourceDemo.class);
		InjectionResourceDemo bean = context.getBean(InjectionResourceDemo.class);
		System.out.println(bean.resource);
		System.out.println(ResourceUtils.getContent(bean.resource));
		System.out.println("=================");
		Stream.of(bean.resources).forEach((e) -> System.out.println(ResourceUtils.getContent(e)));
		context.close();
		System.out.println("=================");
		System.out.println(bean.resourceList);
		bean.resourceList.forEach((e) -> System.out.println(ResourceUtils.getContent(e)));
		context.close();
	}
}
