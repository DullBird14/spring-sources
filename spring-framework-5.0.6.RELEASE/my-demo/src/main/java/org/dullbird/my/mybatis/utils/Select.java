package org.dullbird.my.mybatis.utils;

/**
 * @author cys
 * @date 2020-01-17 23:42
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Select {
	String sql();
}
