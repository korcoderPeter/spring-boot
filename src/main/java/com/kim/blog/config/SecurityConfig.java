package com.kim.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kim.blog.auth.PrincipalDetail;
import com.kim.blog.auth.PrincipalDetailService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// 빈 등록 : 스프링 컨테이너에서 객체를 관리 할수 있게 하는 것

@Configuration // 빈등록 (loc 관리 )
@EnableWebSecurity // 시큐리티 필터 추가 = 스프링 시큐리티가 활성화가 되어 잇는데 어떤 설정을 해당 파일에서 하겠다
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠습니다
@AllArgsConstructor
@NoArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean // Ioc가 됨
	public BCryptPasswordEncoder encoderPWD() {
		return new BCryptPasswordEncoder();
	}
	// 시큐리티가 대신 로그인 해주는데 password를 가로채기를 하는데
	// 해당 password가 뭘로 해쉬가 되어 회원가입되었는지 알아야
	// 같은 해쉬로 암호화해서 db에 있는 해쉬랑 비교할수 있음.
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encoderPWD());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		super.configure(http);
		http
		.csrf().disable() // csrf 토큰 비활성화 테스트시 걸우두는게 좋음
		.authorizeRequests()
		// 어떤 요청이 들오면
		.antMatchers("/","/auth/**", "/js/**", "/css/**", "/image/**")
		// 이 주소라면 
		.permitAll()
		// 허락
		.anyRequest()
		// 하지만 다른 주소로 들어오면
		.authenticated()
		// 허락 안함 하지만
		.and().
		// 로그인 화면으로 들어올수 있음
		formLogin().loginPage("/auth/loginForm")
		.loginProcessingUrl("/auth/loginProc") // 스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인 해준다
		.defaultSuccessUrl("/"); // 정상일때 / 비정상적일 때 => failureurl
		
		
	}

}
