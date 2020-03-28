package org.dullbird.demo.config;

import org.dullbird.demo.annotation.EnableImportAwareConfiguration;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author cys
 * @date 2019-12-22 22:40
 */
@Configuration
@ComponentScan("org.dullbird.demo")
//@Import({ImportAwareConfiguration.class})
@EnableImportAwareConfiguration(value = 2, valueTwo = 3)
public class MainConfiguration {

}
