package com.intelliment.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import com.intelliment.model.SampleParagraph;

@Service
public class ParagraphService implements ParagraphServiceInterface{

	SampleParagraph para;
	
	public ParagraphService() {
		para = new SampleParagraph();
	}
	
	public void setParagraph(SampleParagraph p) {
		para = p;
	}
	
	public SampleParagraph getParagraph(){
		String content = "";
		try {
			content = new String(Files.readAllBytes(Paths.get("C:\\Bhavya\\workspace\\RestServiceCounterApi\\src\\main\\java\\com\\intelliment\\util\\para.txt")));
		} catch (IOException e) {
			System.out.println("File is not found");
		}
		para.setParagraphText(content);
		return para;
	}
	
}
