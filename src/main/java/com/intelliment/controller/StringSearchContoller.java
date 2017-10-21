package com.intelliment.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.intelliment.model.SearchParagraphText;
import com.intelliment.service.SearchParagraghServiceInterface;
import com.intelliment.service.SearchParagraphService;
import com.intelliment.util.TopWordCountModel;



@Service
@RestController
public class StringSearchContoller {
	
	private SearchParagraghServiceInterface _service;

	@Autowired
	public StringSearchContoller(SearchParagraghServiceInterface servicep) {
		_service = servicep;
	}
	
	public StringSearchContoller() {
		
	}
	
	
	@RequestMapping(value="/counter-api/getTop/{n}",method=RequestMethod.GET,headers="Accept=application/json",produces="application/csv")
	public  void GetTopWords(@PathVariable("n") int n,HttpServletResponse response) throws IOException {
		String csvFileName = "top.csv";
		 
        response.setContentType("text/csv");
 
        // creates mock data
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        response.setHeader(headerKey, headerValue);
        
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
        String[] header = { "word", "count"};
        csvWriter.writeHeader(header);
        Map<String,Integer> topMap =  _service.GetTop(n);
       
        for (Map.Entry<String,Integer> item : topMap.entrySet()) {
        	TopWordCountModel t = new TopWordCountModel(item.getKey(),item.getValue());
            csvWriter.write(t, header);
        }
        csvWriter.close();
        
    }
	
	
	@RequestMapping(value="/counter-api/search",method=RequestMethod.POST,headers="Accept=application/json")
    public HashMap<String,Integer> SearchWords(@RequestBody SearchParagraphText strT) {
        return _service.SearchStringCount(strT.SearchText);
    }

}
