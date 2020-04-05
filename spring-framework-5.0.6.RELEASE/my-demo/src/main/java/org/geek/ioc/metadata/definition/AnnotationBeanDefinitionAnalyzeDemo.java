package org.geek.ioc.metadata.definition;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月05日 10:05:00
 */
public class AnnotationBeanDefinitionAnalyzeDemo {
	public static void main(String[] args) {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(factory);
		reader.register(AnnotationBeanDefinitionAnalyzeDemo.class);

	}
}
