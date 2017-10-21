package com.intelliment.model;

import org.springframework.stereotype.Component;

@Component
public class SearchParagraphText {

	public String[] SearchText;
	
	public SearchParagraphText() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SearchParagraphText(String[] searchText) {
		super();
		SearchText = searchText;
	}


	public String[] getSearchText() {
		return SearchText;
	}

	public void setSearchText(String[] searchText) {
		SearchText = searchText;
	}

	
}
