package com.kim.blog.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class board {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob
	private String content; // 섬머노트 라이브러리 <html> 태그가 섞여서 디자인됨
	
	
	private int count; //조회수
	
	@ManyToOne // many = board, user = one 많은 게시판은 유저 하나의 의해 생길수 있음
	// ManyToOne == 외래키
	@JoinColumn(name="userId")
	private UserPeter user; // db는 오브젝트를 저장할수 없다, fk, 자바는 오브젝트를 저장할수 있다.
	
	
	@CreationTimestamp
	private java.sql.Timestamp createDate;


	public board() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public UserPeter getUser() {
		return user;
	}


	public void setUser(UserPeter user) {
		this.user = user;
	}


	public java.sql.Timestamp getCreateDate() {
		return createDate;
	}


	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}


	public board(int id, String title, String content, int count, UserPeter user, java.sql.Timestamp createDate) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.count = count;
		this.user = user;
		this.createDate = createDate;
	}
	
	
}
