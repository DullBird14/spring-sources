package org.dullbird.my.mybatis;

import org.dullbird.my.mybatis.config.CysConfig;
import org.dullbird.my.mybatis.mapper.AccountMapper;
import org.dullbird.my.mybatis.mapper.UserMapper;
import org.dullbird.my.mybatis.utils.CysSession;
import org.dullbird.my.mybatis.utils.MapperHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.reflect.Proxy;

/**
 * @author cys
 * @date 2019-12-22 22:27
 */
public class StartApplication {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CysConfig.class);
		AccountMapper accountMapper = context.getBean(AccountMapper.class);
		accountMapper.selectById(12);
//		UserMapper userMapper = (UserMapper)context.getBean("userMapper");

		UserMapper userMapper = context.getBean(UserMapper.class);
		userMapper.selectById(50);
//		UserMapper userMapper = (UserMapper)CysSession.getMapper(UserMapper.class);
//		userMapper.selectById(55);

	}
}
