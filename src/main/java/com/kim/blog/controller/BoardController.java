package com.kim.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.kim.blog.model.board;
import com.kim.blog.service.BoardService;





@Controller
public class BoardController {
	
	
	@Autowired
	private BoardService boardService;
	
//	@Autowired
//	private PrincipalDetail principal; //두번째 방법
	
	@GetMapping({"", "/"}) // 세션을 어떻게 찾아? 아래 어노테이션
	public String index(Model model, @PageableDefault(size = 2, sort = "id")Pageable pageable) { // 첫번째 방법 =>@AuthenticationPrincipal PrincipalDetail principal
//		System.out.println("로그인 사용자 아이디 :"+ principal.getUsername());
		model.addAttribute("boards", boardService.selectList(pageable));
		return "index";
	}
	
	
	// user 권한이 필요
	@GetMapping("board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.writeDetail(id));
		return "board/updateForm";
	}
	
	
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.writeDetail(id));
		return "board/detail";
	}
	
	
}
