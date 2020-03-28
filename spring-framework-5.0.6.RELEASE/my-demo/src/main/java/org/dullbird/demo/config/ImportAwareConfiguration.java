package org.dullbird.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportAware;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @author cys
 * @date 2019-12-29 17:22
 */
//必须是Configuration
@Configuration
//虽然@import可以注入@Component，但是@Component不行
//@Component
public class ImportAwareConfiguration implements ImportAware {
	@Override
	public void setImportMetadata(AnnotationMetadata importMetadata) {
		//其中可以获取注解中的值
		System.out.println(importMetadata);
	}
}
