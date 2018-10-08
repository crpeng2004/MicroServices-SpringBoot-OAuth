package com.vipul.cloud;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResouceController {

	@RequestMapping("/resource/endpoint")
	@PreAuthorize("hasRole('ADMIN')")
	public String endpoint(){
		return "This is a response from endpoint.";
	}
}
