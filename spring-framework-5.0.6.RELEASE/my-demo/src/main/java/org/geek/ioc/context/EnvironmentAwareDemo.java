package org.geek.ioc.context;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月12日 23:59:00
 */
@Configuration
public class EnvironmentAwareDemo implements EnvironmentAware {
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("environment aware successful");
	}

}
