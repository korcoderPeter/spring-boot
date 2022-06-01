package com.kim.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kim.blog.dto.ResponseDto;
import com.kim.blog.model.RoleType;
import com.kim.blog.model.UserPeter;
import com.kim.blog.repository.UserRepository;
import com.kim.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService us;
	
	@Autowired
	private BCryptPasswordEncoder encode;
	
	@PostMapping("/auth/joinProc") // blog/api/user
	public ResponseDto<Integer> save(@RequestBody UserPeter user) { // username, password, email
		System.out.println("UserApiController");
		us.join(user);
		// 실제로 DB에 insert를 하고 아래에서 return 하면됨
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);	
		
	}
	
	
	
	
	
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody UserPeter user, HttpSession session){
//		UserPeter principal = us.login(user); // principal(접근 주체)
//		
//		if(principal != null) {
//			session.setAttribute("loginsession", principal);
//		}
//		
//		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//		
//	}
	
	
}
