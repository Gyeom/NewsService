package com.example.spring02.service.news;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.spring02.model.news.dao.NewsDAO;
import com.example.spring02.model.news.dto.KeywordDTO;

@Service
public class NewsServiceImpl implements NewsService {
	@Inject
	NewsDAO newsDAO;
	
	@Override
	public void update(String keyword) {
		// TODO Auto-generated method stub
		newsDAO.update(keyword);
	}
	@Override
	public List<KeywordDTO> viewNews(){
		return newsDAO.viewNews();
	}
}
