package com.kim.blog.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kim.blog.auth.PrincipalDetail;
import com.kim.blog.dto.ResponseDto;
import com.kim.blog.model.board;
import com.kim.blog.service.BoardService;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board") // blog/api/user /api/board
	public ResponseDto<Integer> save(@RequestBody com.kim.blog.model.board board, @AuthenticationPrincipal PrincipalDetail principal) { 
		boardService.write(board, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);	
	}

	
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id){
		boardService.delete(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1); // 이거 뜨면 모두 정상
	}
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody board board){
		boardService.update(id, board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
}
