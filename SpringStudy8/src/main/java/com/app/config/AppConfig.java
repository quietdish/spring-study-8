package com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySource("classpath:config/api.properties")

//@PropertySources({
//	@PropertySource("classpath:config/abc.properties")
//	@PropertySource("classpath:config/def.properties")
//})
public class AppConfig {
	
}
