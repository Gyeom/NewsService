package com.example.spring02.controller.news;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.model.news.dto.NewsDTO;
import com.example.spring02.service.news.NewsService;

@Controller
@RequestMapping("news/*") 
public class NewsController {
	@Inject
	NewsService newsService;
	
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue="AI") String keyword, HttpSession session) {
		
		List<NewsDTO> newsList;
		if(session.getAttribute(keyword)==null) {
			newsService.update(keyword);
			newsList = new ArrayList<NewsDTO>();	
			
			try {
				Document doc = Jsoup.connect("https://www.ccn.com/?s="+keyword+" Technology").get();
				Elements news = doc.select("div.article").select("article.latestPost> a");
				String contents = "";
				
				for(int i=0; i<3; i++){
					Element e = news.get(i);
						String link = e.attr("href"); // link
						Document docs = Jsoup.connect(link).get();
						
						String headline = docs.select("header > h1").first().text(); // headline
						String image = docs.select("div.single_post").get(0).select("header > img").first().attr("src"); // image
						Elements content = docs.select("div.thecontent").get(0).select("p");
					
						for (Element e2 : content) {
							contents += e2.text(); //contents
						}
						System.out.println(link);
						System.out.println(image);
						System.out.println(contents);
						System.out.println(headline);
						
						newsList.add(new NewsDTO(headline, image, contents));
					}
				session.setAttribute(keyword, newsList);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}else {
			newsList = (List)session.getAttribute(keyword);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", newsList);
		mav.addObject("keyword",keyword);
		mav.setViewName("news/list");
		
		return mav;
	}
	
	@RequestMapping("view.do")
	public ModelAndView list(@RequestParam String num, @RequestParam String keyword, HttpSession session) {
		List<NewsDTO> newsList = (List)session.getAttribute(keyword);
		ModelAndView mav = new ModelAndView();
		int vnum= Integer.parseInt(num)-1;
		mav.addObject("num",vnum);
		mav.addObject("news",newsList.get(vnum));
		mav.addObject("keyword", keyword);
		mav.setViewName("news/view");
		return mav;
	}
	
}
