package com.kim.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

// ORM => JAVA (다른 언어) Object 
@Entity // UserPeter 클래스가 Database에 테이블이 생성
@DynamicInsert
@NoArgsConstructor
@AllArgsConstructor
public class UserPeter {
	
	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.SEQUENCE) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다
	// @GeneratedValue(strategy = GenerationType.아이덴티티) => mysql 전략
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable = false, length = 30, unique = true) //(unique = true)== (parimary key)
	private String username; // 아이디
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email; // myEmail, my_email
	
	//@ColumnDefault("user") // 디폴트값 설
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum을 쓰는게 좋다. => 강제로 USER, ADMIN
	
	@CreationTimestamp // 시간이 자동입력
	private java.sql.Timestamp createDate;

	
	
	// getter, setter => @Data NoArgsConstructor AllArgsConstructor Builder를 하면 되는 롬복이 안되서 그냥 함
	public UserPeter() {
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public RoleType getRole() {
		return role;
	}



	public void setRole(RoleType role) {
		this.role = role;
	}



	public java.sql.Timestamp getCreateDate() {
		return createDate;
	}



	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}



	public UserPeter(int id, String username, String password, String email, RoleType role, Timestamp createDate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.createDate = createDate;
	}
	
	
	
}
