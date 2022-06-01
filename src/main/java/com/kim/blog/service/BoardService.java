package com.kim.blog.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kim.blog.model.RoleType;
import com.kim.blog.model.UserPeter;
import com.kim.blog.model.board;
import com.kim.blog.repository.BoardRepository;
import com.kim.blog.repository.UserRepository;


// 스프링이 컴포넌트 스캔을 통해서 빈에 등록해줌 loc를 해줌
@Service
public class BoardService {
	
	@Autowired
	private BoardRepository bRepository;
	
	
	
	@org.springframework.transaction.annotation.Transactional
	public void write(board board, UserPeter user) {
		System.out.println(user.getId());
		System.out.println(board.getTitle());
		System.out.println(board.getContent());
		board.setCount(0);
		board.setUser(user);
		bRepository.save(board);
			
	}
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public Page<board> selectList(Pageable pageable){
		return bRepository.findAll(pageable);
	}
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public board writeDetail(int id) {
		return bRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글상세보기 실패 : 아이디를 찾을수 없습니다");
		});
	}
	@org.springframework.transaction.annotation.Transactional
	public  void delete(int id) {
		bRepository.deleteById(id);
				
	}
}
