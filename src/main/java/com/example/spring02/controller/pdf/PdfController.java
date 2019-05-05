package com.example.spring02.controller.pdf;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.news.dto.NewsDTO;
import com.example.spring02.service.pdf.PdfService;

@Controller //而⑦듃濡ㅻ윭 鍮덉쑝濡� �벑濡�
@RequestMapping("pdf/*") //怨듯넻�쟻�씤 url mapping
public class PdfController {
	@Inject
	PdfService pdfService;

	@RequestMapping("list.do") //�꽭遺��쟻�씤 url mapping
	public ModelAndView list(@RequestParam String keyword, @RequestParam String num, HttpSession session) throws Exception {
		String result=pdfService.createPdf((List<NewsDTO>)session.getAttribute(keyword),Integer.parseInt(num));
		ModelAndView mav = new ModelAndView();
		mav.addObject("keyword",keyword);
		mav.addObject("num",num+1);
		mav.addObject("message",result);
		mav.setViewName("pdf/result");
		return mav;
	}
}







