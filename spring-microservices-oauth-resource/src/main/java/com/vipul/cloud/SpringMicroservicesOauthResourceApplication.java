package com.vipul.cloud;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

@SpringBootApplication
// This is to enable this application as resource server
@EnableResourceServer
// This is to enable method level security configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringMicroservicesOauthResourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesOauthResourceApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:mem:testdb");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		dataSource.setDriverClassName("org.h2.Driver");
		return dataSource;
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource());
	}

	@Primary
	@Bean
	public RemoteTokenServices tokenServices() {
		RemoteTokenServices tokenServices = new RemoteTokenServices();
		tokenServices.setCheckTokenEndpointUrl("http://localhost:9090/oauth/check_token");
		tokenServices.setClientId("resource1");
		tokenServices.setClientSecret("secret");
		return tokenServices;
	}
}
