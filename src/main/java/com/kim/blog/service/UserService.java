package com.kim.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kim.blog.model.RoleType;
import com.kim.blog.model.UserPeter;
import com.kim.blog.repository.UserRepository;


// 스프링이 컴포넌트 스캔을 통해서 빈에 등록해줌 loc를 해줌
@Service
public class UserService {
	
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@org.springframework.transaction.annotation.Transactional
	public void join(UserPeter user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		System.out.println(encPassword);
			
			
		uRepository.save(user);
			
	}
//	@org.springframework.transaction.annotation.Transactional(readOnly = true) // select할 때 트랙잭션 시작, 서비스 종료시에 트랜잭션 종료 (정합성)
//	public UserPeter login(UserPeter user) {
//		return uRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}

}
