package com.vipul.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResouceController {

	@RequestMapping("/resource/endpoint")
	public String endpoint(){
		return "This is a response from endpoint.";
	}
}
