package com.example.spring02.model.news.dao;

import java.util.List;

import com.example.spring02.model.news.dto.KeywordDTO;

public interface NewsDAO {
	public void update(String keyword);
	public List<KeywordDTO> viewNews();
}
