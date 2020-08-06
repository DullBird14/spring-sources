package org.geek.ioc.annotation;

import org.springframework.beans.factory.support.*;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月06日 22:29:00
 */
public class ImportIntegerRegister implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
										BeanDefinitionRegistry registry) {
		AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(
				ImportConfiguration.class).getBeanDefinition();
		BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
	}
}
