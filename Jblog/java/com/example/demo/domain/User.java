package com.example.demo.domain ;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
@Builder
@Entity
public class User {  //엔티티 클래스로부터 생성된 객체를 기반으로 데이터베이스 연동을 처리한다.

	@Id  //기본키에 대응하는 식별자 변수
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //1부터 시작하여 자동 1씩 증가
	private int id;
	
	@Column(nullable = false, length = 50, unique = true)  
	private String username;
	
	@Column(length = 100)
	private String password;
	
	@Column(nullable = false, length = 100)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private RoleType role;
	
	@CreationTimestamp  // 현재 시간이 기본값으로 설정
	private Timestamp createDate;
	
   
   

}
