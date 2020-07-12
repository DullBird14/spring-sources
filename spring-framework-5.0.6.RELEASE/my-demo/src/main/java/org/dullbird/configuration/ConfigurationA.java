package org.dullbird.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月20日 22:35:00
 */
@Configuration
public class ConfigurationA {
	@Bean
	public String testA(){
		return "testA";
	}
}
