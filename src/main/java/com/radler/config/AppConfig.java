package com.radler.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;

@Configuration 
@PropertySource("classpath:db/jdbc.properties")
@ComponentScan(basePackages = {
		"com.radler.app",
		"com.radler.dao",
		"com.radler.crud"
})
public class AppConfig {
	private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
	@Value("${driverClassName}")
	private String driverClassName;
	@Value("${url}")
	private String url;
	@Value("${login}")
	private String username;
	@Value("${password}")
	private String password;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
		
	}
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		try {
			BasicDataSource dataSource  = new BasicDataSource(); 
			dataSource.setDriverClassName(driverClassName);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			return dataSource;
		} catch (Exception e) {
			logger.error("Datasource Bean could not be created");
			return null;
		}
	}
}

