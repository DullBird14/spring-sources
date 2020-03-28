package org.dullbird.my.mybatis.utils;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cys
 * @date 2020-01-17 23:41
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(CysBeanDefinitionRegeister.class)
public @interface CysMapperScan {
	String value()  default "";
}
