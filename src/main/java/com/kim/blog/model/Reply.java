package com.kim.blog.model;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

public class Reply {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	@Column(nullable = false, length = 200)
	private String content;
	
	@ManyToOne
	@JoinColumn(name="boradId")
	private board board;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private UserPeter user;
	
	@CreationTimestamp
	private java.sql.Timestamp createDate;
	
	
}
