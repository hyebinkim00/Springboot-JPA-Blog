package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
/*
 * @DynamicInsert //insert 시 null인 필드 제외시켜줌
 */
public class User {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id; //auto-increment
		
		@Column(nullable=false, length=30)
		private String username;
		
		@Column(nullable=false, length=100)
		private String password;
		
		@Column(nullable=false, length=50)
		private String email;
		
		/* @ColumnDefault("'user'") */
		@Enumerated(EnumType.STRING)
		private RoleType role; //Enum을 쓰는게 좋다.
		
		@CreationTimestamp //시간 자동 입력
		private Timestamp createDate;
		
}
