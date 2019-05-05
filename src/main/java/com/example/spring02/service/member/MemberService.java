package com.example.spring02.service.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring02.model.member.dto.MemberDTO;
import com.example.spring02.model.shop.dto.CartDTO;

public interface MemberService {
	
	public boolean loginCheck(
				MemberDTO dto, HttpSession session);
	public boolean joinCheck(MemberDTO dto);
	public List<MemberDTO> viewMember(); 
	public void logout(HttpSession session);
	public MemberDTO viewMember(String userid);
}
