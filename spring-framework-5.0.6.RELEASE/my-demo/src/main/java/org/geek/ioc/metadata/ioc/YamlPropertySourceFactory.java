package org.geek.ioc.metadata.ioc;

import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * 实现一个自己解析 yaml的 propertySource 的方法
 *
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月05日 16:26:00
 * @see YamlMapFactoryBean
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {
	@Override
	public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
		YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
		yamlPropertiesFactoryBean.setResources(resource.getResource());
		Properties object = yamlPropertiesFactoryBean.getObject();
		return new PropertiesPropertySource(name, object);
	}
}
