package org.geek.ioc.annotation;

import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年08月03日 14:33:00
 */
@ComponentScan("org.yungu.temp")
public class ComponentScanDemo {
	public static void main(String[] args) {
//		AnnotationConfigUtils.attributesForRepeatable(
//				sourceClass.getMetadata(), ComponentScans.class, ComponentScan.class);
	}
}
