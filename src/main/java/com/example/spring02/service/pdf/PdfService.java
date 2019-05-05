package com.example.spring02.service.pdf;

import java.util.List;

import com.example.spring02.model.news.dto.NewsDTO;

public interface PdfService {
	public String createPdf(List<NewsDTO> newsList, int num);
}
