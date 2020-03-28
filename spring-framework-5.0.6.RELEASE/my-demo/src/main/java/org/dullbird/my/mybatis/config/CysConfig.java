package org.dullbird.my.mybatis.config;

import org.dullbird.my.mybatis.mapper.UserMapper;
import org.dullbird.my.mybatis.utils.CysMapperScan;
import org.dullbird.my.mybatis.utils.CysSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author cys
 * @date 2020-01-18 00:06
 */
@CysMapperScan("org.dullbird.my.mybatis.mapper")
@Configuration
@ComponentScan("org.dullbird.my.mybatis")
public class CysConfig {
//	@Bean
//	public UserMapper userMapper(){
//		return (UserMapper)CysSession.getMapper(UserMapper.class);
//	}
}
