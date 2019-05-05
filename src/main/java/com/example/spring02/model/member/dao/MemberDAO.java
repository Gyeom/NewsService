package com.example.spring02.model.member.dao;

import java.util.List;

import com.example.spring02.model.member.dto.MemberDTO;

public interface MemberDAO {
	public boolean loginCheck(MemberDTO dto);
	public boolean joinCheck(MemberDTO dto);
	public List<MemberDTO> viewMember(); 
	public MemberDTO viewMember(String userid);
}
