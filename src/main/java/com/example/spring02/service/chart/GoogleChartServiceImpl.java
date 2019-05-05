package com.example.spring02.service.chart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import com.example.spring02.model.member.dto.MemberDTO;
import com.example.spring02.model.news.dto.KeywordDTO;
import com.example.spring02.service.member.MemberService;
import com.example.spring02.service.news.NewsService;

@Service
public class GoogleChartServiceImpl 
	implements GoogleChartService {

	@Inject //�쓽議닿�怨� 二쇱엯(�옣諛붽뎄�땲 �꽌鍮꾩뒪)
	MemberService memberService;
	@Inject
	NewsService newsService;
	
	@Override
	public JSONArray getChartDate(){
		List<MemberDTO> items=memberService.viewMember();
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for(MemberDTO dto : items) {
			DateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
			String tempDate = sdFormat.format(dto.getJoin_date());

				if(!map.containsKey(tempDate)) {
					map.put(tempDate, 1);
				}else {
					map.put(tempDate,map.get(tempDate)+1);
				}
		}
		JSONArray body = new JSONArray();
		for(String date : map.keySet()) {
			JSONObject obj = new JSONObject();
			obj.put("YYYY", date.substring(0,4));
			obj.put("MM", date.substring(4,6));
			obj.put("dd", date.substring(6,8));
			obj.put("value", map.get(date));
			body.add(obj);
		}
		return body;
	}
	
	public JSONArray getChartKeyword(){
		List<KeywordDTO> items= newsService.viewNews();
		System.out.println(items.toString());
		JSONArray body = new JSONArray();
		for(KeywordDTO dto : items) {
			JSONObject obj = new JSONObject();
			obj.put("keyword", dto.getKeyword());
			obj.put("cnt",dto.getCnt());
			body.add(obj);
		}
		return body;
	}

}






