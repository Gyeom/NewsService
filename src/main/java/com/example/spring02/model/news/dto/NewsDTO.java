package com.example.spring02.model.news.dto;

public class NewsDTO {
	String headline;
	String image;
	String contents;
	
	public NewsDTO(String headline, String image, String contents){
		this.headline=headline;
		this.image=image;
		this.contents=contents;
	}
	public String getHeadline() {
		return headline;
	}
	public void setHeadline(String headline) {
		this.headline = headline;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "NewsDTO [headline=" + headline + ", image=" + image + ", contents=" + contents + "]";
	}
	
}
