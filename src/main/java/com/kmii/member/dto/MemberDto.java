package com.kmii.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {
	
	private String id; //회원 아이디
	private String password; //회원 비밀번호
	private String confirmPassword; //회원 비밀번호 확인용
	private String name; //회원 이름
	private String email; //회원 이메일
	private int age; //회원 나이

	
}

