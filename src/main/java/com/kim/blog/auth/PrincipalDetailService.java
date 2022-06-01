package com.kim.blog.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kim.blog.model.UserPeter;
import com.kim.blog.repository.UserRepository;


@Service
public class PrincipalDetailService implements UserDetailsService{
	
	
	@Autowired
	private UserRepository uRepository;
	// 스프링이 로그인 요청을 가로챌 때, username, password 변수 2개를 가로 채는데
	// password 부분 처리는 알아서 함
	// username이 db에 있는지만 확인해주면 됨
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserPeter principal = uRepository.findByUsername(username).
				orElseThrow(()-> {
					return new  UsernameNotFoundException("해당 유저를 찾을 수 없습니다. :"+username);
				});
		return new PrincipalDetail(principal); // 시큐리티의 세션에 유저 정보가 저장이됨. 아이디 user, 패스워드 콘솔창
	}
	
	
	
}
