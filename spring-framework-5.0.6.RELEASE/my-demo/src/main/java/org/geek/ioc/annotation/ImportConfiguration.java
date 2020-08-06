package org.geek.ioc.annotation;

import org.springframework.context.annotation.Bean;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月06日 22:14:00
 */
public class ImportConfiguration {

	@Bean
	public Integer one() {
		return 1;
	}
}
