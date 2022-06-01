package com.kim.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kim.blog.model.UserPeter;
import com.kim.blog.model.board;


public interface BoardRepository extends JpaRepository<board, Integer> {

	
}

 