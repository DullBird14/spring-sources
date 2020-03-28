package org.geek.ioc.lifecycle;

import org.geek.ioc.overview.dependent.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * 第一步，BeanDefinition 的解析
 * 1。xml方式 XmlBeanDefinitionReader
 * 2。注解 AnnotatedBeanDefinitionReader
 * 3。properties PropertiesBeanDefinitionReader
 * 4. groovy的略
 * @author dullBird
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年03月15日 18:26:00
 * @see XmlBeanDefinitionReader
 * @see AnnotatedBeanDefinitionReader
 * @see PropertiesBeanDefinitionReader
 */
public class OneBeanDefinitionParseDemo {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		// 需要一个 beanFactoryRegistry
		PropertiesBeanDefinitionReader reader = new PropertiesBeanDefinitionReader(factory);
//		String path = "classpath:/META-INF/user-definition.properties";
		String path = "META-INF/user-definition.properties";
		Resource resource = new ClassPathResource(path);
		//处理下面的中文乱码
		EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");

		int i = reader.loadBeanDefinitions(encodedResource);
		System.out.println(i);
		User bean = factory.getBean(User.class);
		System.out.println(bean);
		/**
		 * 由于 读取 properties 的字符集不是utf-8所以需要换一种方式
		 * 1
		 * ==============User afterPropertiesSet =======
		 * User{id=1, name='èé¸'}
		 */
	}
}
