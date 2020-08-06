package org.geek.ioc.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * {@link ImportSelector}
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月06日 22:17:00
 */
public class ImportIntegerSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{
			"org.geek.ioc.annotation.ImportConfiguration"
		};
	}
}
