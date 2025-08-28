package com.kmii.member.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kmii.member.dto.MemberDto;
import com.kmii.member.validation.MemberValidator;

@Controller
public class MemberController {
	
	@RequestMapping(value = "/memberJoin")
	public String memberJoin() {
		
		return "memberJoin";
	}
	
	
	
	
	@RequestMapping(value = "/memberJoinOk")
	public String memberJoinOk(@ModelAttribute("memberDto") MemberDto memberDto, Model model, BindingResult result) {
		
		MemberValidator memberValidator = new MemberValidator();
		memberValidator.validate(memberDto, result);
		
		if(result.hasErrors()) { //에러가 있는지 확인(유효성 체크)
			List<ObjectError> allErrors = result.getAllErrors(); //모든 에러 포함
			List<String> errorMsg = new ArrayList<String>();
			
			for(ObjectError error :allErrors) {
				 //에러메시지
				errorMsg.add(error.getDefaultMessage());
			}
			
			model.addAttribute("signupError", "회원 가입에 실패하였습니다.");
			model.addAttribute("errorMsg", errorMsg);
			
			model.addAttribute("memberDto",memberDto); // 
			
			return "memberJoin";
		}
		
		model.addAttribute("memberDto",memberDto);  // 통과했으면 에러 없다는것 -> memberDto에 담아 넘겨준다
		return "memberJoinOk";
	}

}
