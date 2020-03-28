package org.dullbird.my.mybatis.utils;

import org.dullbird.my.mybatis.mapper.AccountMapper;
import org.dullbird.my.mybatis.mapper.UserMapper;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author cys
 * @date 2020-01-18 00:08
 */
@Component
public class CysBeanDefinitionRegeister implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		Map<String, Object> cysMapperScan = importingClassMetadata.getAnnotationAttributes("org.dullbird.my.mybatis.utils.CysMapperScan");
		System.out.println("扫描下面的包:" + cysMapperScan);
		Class[] scanClass = new Class[]{UserMapper.class, AccountMapper.class};
		for (Class aClass : scanClass) {
			AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(MapperFactoryBean.class).getBeanDefinition();
			MutablePropertyValues propertyValues = new MutablePropertyValues();
//			propertyValues.addPropertyValue("mapperInterface", "org.dullbird.my.mybatis.mapper.UserMapper");
			propertyValues.addPropertyValue("mapperInterface", aClass);
			beanDefinition.setPropertyValues(propertyValues);
			registry.registerBeanDefinition(aClass.getSimpleName(), beanDefinition);
		}
	}
}
