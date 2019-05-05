package com.example.spring02.model.chart;

public class ChartDTO {
	private String YYYY;
	private String MM;
	private String dd;
	private String value;
	
	public ChartDTO(String YYYY, String MM, String dd, String value){
		this.YYYY=YYYY;
		this.MM=MM;
		this.dd=dd;
		this.value=value;
	}
	public String getYYYY() {
		return YYYY;
	}
	public void setYYYY(String yYYY) {
		YYYY = yYYY;
	}
	public String getMM() {
		return MM;
	}
	public void setMM(String mM) {
		MM = mM;
	}
	public String getDd() {
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
