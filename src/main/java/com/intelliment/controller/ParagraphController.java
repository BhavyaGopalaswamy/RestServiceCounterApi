package com.intelliment.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intelliment.model.SampleParagraph;
import com.intelliment.service.ParagraphService;
import com.intelliment.service.ParagraphServiceInterface;
import com.intelliment.service.SearchParagraghServiceInterface;

@RestController
public class ParagraphController {
	
	private ParagraphServiceInterface paraService;

	@Autowired
	public ParagraphController(ParagraphServiceInterface pservice){
		paraService = pservice;
	}
	
	@RequestMapping(value="/paragraph/getText",method=RequestMethod.GET,headers="Accept=application/json")
    public SampleParagraph getText() throws IOException {
		return paraService.getParagraph();
        
    }
}
