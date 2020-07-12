package org.dullbird.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月20日 22:35:00
 */
@Import(ConfigurationA.class)
public class ImportConfigurationDemo {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ImportConfigurationDemo.class);
		context.close();
	}
}
