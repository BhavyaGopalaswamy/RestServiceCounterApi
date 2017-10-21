package com.intelliment.model;

import org.springframework.stereotype.Component;

@Component
public class SampleParagraph {
	
	String paragraphText;

	public SampleParagraph() {
		super();
	}

	public SampleParagraph(String paragraphText) {
		super();
		this.paragraphText = paragraphText;
	}

	public String getParagraphText() {
		return paragraphText;
	}

	public void setParagraphText(String paragraphText) {
		this.paragraphText = paragraphText;
	}

}
