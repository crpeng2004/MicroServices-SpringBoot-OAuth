package com.vipul.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@SpringBootApplication
@EnableOAuth2Client
public class SpringMicroservicesOauthClientApplication {

	@Bean
	public OAuth2RestTemplate restTemplate() {
		return new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext());
	}

	@Bean
	public OAuth2ProtectedResourceDetails resource() {
		ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
		details.setAccessTokenUri("http://localhost:9090/oauth/token");
		details.setClientId("webapp");
		details.setClientSecret("websecret");
		details.setGrantType("password");
		return details;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesOauthClientApplication.class, args);
	}
}
