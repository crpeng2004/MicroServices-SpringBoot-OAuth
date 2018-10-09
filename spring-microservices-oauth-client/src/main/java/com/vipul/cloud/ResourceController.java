package com.vipul.cloud;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

	@Autowired
	private OAuth2RestTemplate restTemplate;

	@RequestMapping("/execute")
	public String execute(Principal principal) throws URISyntaxException {
		User user = (User) ((Authentication) principal).getPrincipal();
		URI uri = new URI("http://localhost:7070/resource/endpoint");
		RequestEntity<String> request = new RequestEntity<String>(HttpMethod.GET, uri);
		AccessTokenRequest accessTokenRequest = this.restTemplate.getOAuth2ClientContext().getAccessTokenRequest();
		accessTokenRequest.set("username", user.getUsername());
		accessTokenRequest.set("password", user.getPassword());
		return restTemplate.exchange(request, String.class).getBody();
	}

}
