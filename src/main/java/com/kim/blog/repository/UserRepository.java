package com.kim.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kim.blog.model.UserPeter;


// DAO 
// 자동으로 bean등록이 된다
//@Repository 생략이 가능하다
public interface UserRepository extends JpaRepository<UserPeter, Integer> {
	// select * from userPeter where username = 1?;
	Optional<UserPeter> findByUsername(String username);
	
}

//JPA Naming 쿼리
// select * from userpeter where username and password
//	UserPeter findByUsernameAndPassword(String username, String password);
// 2번째 방법
//	@Query(value="SELECT * FROM userpeter WHERE username = ?1 AND password = ?2", nativeQuery = true)
//	UserPeter login(String username, String password);