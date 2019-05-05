package com.example.spring02.model.member.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.member.dto.MemberDTO;

@Repository // Spring�뿉�꽌 愿�由ы븯�뒗 dao bean�쑝濡� �꽕�젙 
public class MemberDAOImpl implements MemberDAO {

	@Inject // mybatis �떎�뻾�쓣 �쐞�븳 SqlSession 媛앹껜瑜� 二쇱엯�떆�궡
	SqlSession sqlSession;
	
	@Override
	public boolean loginCheck(MemberDTO dto) {
		String name
			=sqlSession.selectOne("member.login_check",dto);
		// 議곌굔�떇 ? true�씪 �븣�쓽 媛� : false�씪 �븣�쓽 媛�
		return (name==null) ? false : true; 
	}
	
	@Override
	public boolean joinCheck(MemberDTO dto) {
		int duplicate=0;
		
		try {
			duplicate = sqlSession.insert("member.join_check",dto);
		} catch (Exception e) {
			// TODO: handle exception
			duplicate =0;
		}
		return (duplicate==0) ? false : true; 
	}
	
	@Override
	public List<MemberDTO> viewMember() {
		return sqlSession.selectList("member.allMember");
	}


	@Override
	public MemberDTO viewMember(String userid) {
		return sqlSession.selectOne("member.viewMember", userid);
	}

}




