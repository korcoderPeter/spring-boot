package com.kim.blog.test;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
	
	
	@GetMapping("/test/hello")
	public String test() {
		return "Hello world";
	}

}
