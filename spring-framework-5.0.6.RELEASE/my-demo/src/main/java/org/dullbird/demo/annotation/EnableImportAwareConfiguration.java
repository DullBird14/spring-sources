package org.dullbird.demo.annotation;

import org.dullbird.demo.config.ImportAwareConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cys
 * @date 2019-12-29 17:23
 */


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({ImportAwareConfiguration.class})
public @interface EnableImportAwareConfiguration {
	int value();
	int valueTwo();

}
