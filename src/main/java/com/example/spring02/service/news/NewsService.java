package com.example.spring02.service.news;

import java.util.List;

import com.example.spring02.model.news.dto.KeywordDTO;

public interface NewsService {
	public void update(String keyword);
	public List<KeywordDTO> viewNews();
}
