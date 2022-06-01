package com.kim.blog.test;

import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kim.blog.model.RoleType;
import com.kim.blog.model.UserPeter;
import com.kim.blog.repository.UserRepository;

import antlr.collections.List;
import net.bytebuddy.asm.Advice.OffsetMapping.Sort;


// html파일이 아니라 data를 리턴하는
@RestController
public class DummyControllerTest {
	
	@Autowired // 의존성 주입(DI)
	private UserRepository uRepository;
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id){
		try {
			uRepository.deleteById(id);			
		} catch (Exception e) {
			return "삭제 실패하엿습니다 해당id는 데이터베이스에 존재하지 않습니다";
		}
		return "삭제되었습니다.id:" + id;
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("/dummy/users")
	public java.util.List<UserPeter> list()	{
		java.util.List<UserPeter> user = uRepository.findAll();
		return user;
	}
	
	
	
	//save함수는 id를 전달하지 않으면 insert를 해주고
	// save함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
	// save함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 해여
	@Transactional
	@PutMapping("/dummy/user/{id}") // 업데이트할때는 put 
	public UserPeter update(@PathVariable int id, @RequestBody UserPeter requestUser) { // json 데이터 요청 => java object (/mssageConverter)가 변환해서 보내줌
		System.out.println("id"+id);
		System.out.println("password :"+ requestUser.getPassword());
		System.out.println("email :"+ requestUser.getEmail());
		
		UserPeter user = uRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 유저는 없습니다. id"+ id);
		});	
		user.setPassword(requestUser.getPassword());
		user.setPassword(requestUser.getEmail());
		
//		uRepository.save(user); // save를 활용한 업데이트
		
		// 더티 체킹
		return null;
		
	}
	
	
	
	// 한페이지당 2건에 데이터를 리턴받아 볼예정
	@GetMapping("/dummy/user/page/{page}")
	 //direction = Sort.Direction.DESC
	public java.util.List<UserPeter> pageList(@PageableDefault(size=2, sort = "id") Pageable pageable){
		java.util.List<UserPeter> user = (java.util.List<UserPeter>) uRepository.findAll(pageable);
//		getContent() 페이지 정보
		return user;
		
	}
	
	
	
	// {id} 주소로 파라미터를 전달받을 수 있음.
	// http://localhost:8000/blog/dummy/user/3
	@GetMapping("/dummy/user/{id}")
	public UserPeter detail(@PathVariable int id) {
		// user /4를 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null이 될것 아냐
		// 그럼 return null 이 리턴이 되자나... 그럼 프로그램에 문제가 있지 않겠니?
		// optional로 너의 User 객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return해
		//UserPeter user = uRepository.findById(id).get();
		UserPeter user = uRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없습니다. id"+ id);
			}
//람다식
//UserPeter user = uRepository.findById(id).orElseThrow(()->{				
//return new IllegalArgumentException("해당 유저는 없습니다");
//				});
			
		});
		
		// 요청 : 웹브라우저
		// user 객체 => java
		// 변환 (웹브라우저가 이해할수 있는 데이터 )-> json (Gson 라이브러리)
		// 스프링부트 = messageConverter라는 애가 응답시에 자동 작동
		// 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 jackson 라이브러리를 호출해서 
		// user 오브젝트를 json으로 변환해서 브라우저에게 던져줌
		return user;
	}
	
	
	// http://localhost:8000/blog/dummy/join (요청)
	// http의 바디에서 username, password, email 데이터를 가지고 요청
	@PostMapping("/dummy/test")
	public String join(String username, String password, String email) {
		System.out.println("username :" + username);
		System.out.println("password :" + password);
		System.out.println("email :" + email);
//		up2.setRole(RoleType.User); // 강제로 만들 수있음
		
		UserPeter up = new UserPeter(0, username, password, email, null, null);
		uRepository.save(up);
		return "회원가입이 완료되었습니다";
	}
	
}
