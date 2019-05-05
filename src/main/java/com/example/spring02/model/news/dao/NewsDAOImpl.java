package com.example.spring02.model.news.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.news.dto.KeywordDTO;

@Repository
public class NewsDAOImpl implements NewsDAO {
	@Inject
	SqlSession sqlSession;
	@Override
	public void update(String keyword) {
		// TODO Auto-generated method stub
		sqlSession.update("news.update",keyword);
	}
	public List<KeywordDTO> viewNews(){
		return sqlSession.selectList("news.listAll");
	}
}
