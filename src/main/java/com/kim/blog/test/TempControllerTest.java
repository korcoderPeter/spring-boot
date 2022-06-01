package com.kim.blog.test;

import org.springframework.web.bind.annotation.GetMapping;

public class TempControllerTest {
	
	
	
	// localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("템프홈");
		
		// 파일리턴 기본경로 : src/main/resources/static => 스태틱 경로는 정적인 파일만 넣어야함
		// 리턴명 : /home.html
		return "/home.html";
	}

}
