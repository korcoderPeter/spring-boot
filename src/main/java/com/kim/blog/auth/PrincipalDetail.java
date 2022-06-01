package com.kim.blog.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kim.blog.model.UserPeter;


// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 User Details 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션 저장소에 저장을 해준다
public class PrincipalDetail implements UserDetails{
	private UserPeter user; // 콤포지션
	
	public PrincipalDetail(UserPeter user) {
		this.user = user;
	}
	
	
	public PrincipalDetail() {
		// TODO Auto-generated constructor stub
	}
	
	
	// 마우스 우클릭 => 소스 => 오버라이드, 임플먼트 메소드 클릭

	public UserPeter getUser() {
		return user;
	}








	@Override
	public String getPassword() { // 
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	// 계정이 만료되지 않았는지 리턴한다 
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정이 잠경있지 않은지 리턴한다 (잠기지 않음 : true)
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	// 비밀번호가 만료도지 않은지
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	// 계정이 활성화인지 리턴한다 (true : 활성화)
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	// 계정의 권한 인식
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		
		
		
		collectors.add(new GrantedAuthority() {	
			@Override
			public String getAuthority() {
				return "ROLE_"+user.getRole(); // ROLE_ <= 규칙임
			}
		});
		
		
//		이것도 가능
		//collectors.add(()-> {return "ROLE_"+user.getRole();});
		
		return collectors;
	}
	
}
