package com.example.spring02.controller.chart;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring02.service.chart.GoogleChartService;

@RestController
@RequestMapping("chart/*")
public class GoogleChartController {

	@Inject
	GoogleChartService googleChartService;
	
	@RequestMapping("chart1.do")
	public ModelAndView chart1() {
		return new ModelAndView("chart/chart01");
	}
	
	@RequestMapping("chart2.do")
	public ModelAndView chart2() {
		return new ModelAndView("chart/chart02");
	}
// view(jsp)濡� �꽆�뼱媛�吏� �븡怨� �샇異쒗븳 怨녹뿉 JSONObject瑜� 由ы꽩�븿	
	@RequestMapping("regdate_list.do")
//	public List<MemberDTO> getRegdate(){
	public JSONArray getRegdate() {
		return googleChartService.getChartDate();
	}
	
	@RequestMapping("keyword_list.do")
	public JSONArray getKeyword() {
		return googleChartService.getChartKeyword();
	}
	
}








