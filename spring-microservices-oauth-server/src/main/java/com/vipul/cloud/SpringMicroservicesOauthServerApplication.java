package com.vipul.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
// This is to enable this application as authorization server
@EnableAuthorizationServer
// This is to enable this application as resource server
@EnableResourceServer
// This is to enable method level security configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SpringMicroservicesOauthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesOauthServerApplication.class, args);
	}
}
