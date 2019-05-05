package com.example.spring02.service.chart;

import java.util.List;

import org.json.simple.JSONArray;

import com.example.spring02.model.chart.ChartDTO;

public interface GoogleChartService {
	public JSONArray getChartDate();
	public JSONArray getChartKeyword();
}
