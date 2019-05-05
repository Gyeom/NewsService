package com.example.spring02.controller.member;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.member.dto.MemberDTO;
import com.example.spring02.service.member.MemberService;

@Controller //而⑦듃濡ㅻ윭 鍮덉쑝濡� �벑濡�
@RequestMapping("member/*") //怨듯넻�쟻�씤 url 留ㅽ븨
public class MemberController {
 
	//濡쒓퉭�쓣 �쐞�븳 蹂��닔
	private static final Logger logger=
			LoggerFactory.getLogger(MemberController.class);
	@Inject
	MemberService memberService;
	
	@RequestMapping("login.do") //�꽭遺��쟻�씤 url 留ㅽ븨
	public String login() {
		return "member/login"; // login.jsp濡� �씠�룞
	}
	@RequestMapping("join.do") //�꽭遺��쟻�씤 url 留ㅽ븨
	public String join() {
		return "member/join"; // login.jsp濡� �씠�룞
	}
	@RequestMapping("login_check.do")
	public ModelAndView login_check(
			MemberDTO dto, HttpSession session) {
		//濡쒓렇�씤 �꽦怨� true, �떎�뙣 false
		boolean result=memberService.loginCheck(dto, session);
		ModelAndView mav=new ModelAndView();
		if(result) { //濡쒓렇�씤 �꽦怨�
			mav.setViewName("home"); //酉곗쓽 �씠由�
		}else { //濡쒓렇�씤 �떎�뙣
			mav.setViewName("member/login");
			//酉곗뿉 �쟾�떖�븷 媛�
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("join_check.do")
	public ModelAndView join_check(
			MemberDTO dto) {
		
		boolean result=memberService.joinCheck(dto);
		ModelAndView mav=new ModelAndView();
		if(result) { //濡쒓렇�씤 �꽦怨�
			mav.setViewName("member/login"); //酉곗쓽 �씠由�
		}else { //濡쒓렇�씤 �떎�뙣
			mav.setViewName("member/join");
			//酉곗뿉 �쟾�떖�븷 媛�
			mav.addObject("message", "error");
		}
		return mav;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(
			HttpSession session,ModelAndView mav) {
		//�꽭�뀡 珥덇린�솕
		memberService.logout(session);
		// login.jsp濡� �씠�룞
		mav.setViewName("member/login");
		mav.addObject("message","logout");
		return mav;
	}
	
}









