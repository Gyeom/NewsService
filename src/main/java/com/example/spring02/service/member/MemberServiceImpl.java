package com.example.spring02.service.member;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.example.spring02.model.member.dao.MemberDAO;
import com.example.spring02.model.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	MemberDAO memberDao;
	
	@Override
	public boolean loginCheck(
			MemberDTO dto, HttpSession session) {
		boolean result=memberDao.loginCheck(dto);
		if(result) { //濡쒓렇�씤 �꽦怨�
			//�꽭�뀡蹂��닔�뿉 媛� ���옣
			MemberDTO dto2=viewMember(dto.getUserid());
			//setAttribute(蹂��닔紐�,媛�)
			session.setAttribute("userid", dto.getUserid());
			session.setAttribute("name", dto2.getName());
			System.out.println(session.getAttribute("userid"));
			System.out.println(session.getAttribute("name"));
		} 
		return result;
	}
	

	@Override
	public boolean joinCheck(MemberDTO dto) {
		return memberDao.joinCheck(dto);
	}
	
	
	@Override
	public void logout(HttpSession session) {
		//�꽭�뀡 珥덇린�솕
		session.invalidate();
	}
	@Override
	public List<MemberDTO> viewMember() {
		return memberDao.viewMember(); 
	}; 
	
	@Override
	public MemberDTO viewMember(String userid) {
		return memberDao.viewMember(userid); 
	}

}





