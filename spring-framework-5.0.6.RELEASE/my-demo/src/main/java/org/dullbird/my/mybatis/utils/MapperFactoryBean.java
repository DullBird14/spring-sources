package org.dullbird.my.mybatis.utils;

import org.dullbird.my.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * @author cys
 * @date 2020-01-18 00:21
 */

public class MapperFactoryBean implements FactoryBean {

	private Class mapperInterface;

	public Class getMapperInterface() {
		return mapperInterface;
	}

	public void setMapperInterface(Class mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	@SuppressWarnings("unchecked")
	public Object getObject() throws Exception {
		return CysSession.getMapper(mapperInterface);}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}

}
