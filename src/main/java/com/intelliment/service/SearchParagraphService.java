package com.intelliment.service;



import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.intelliment.model.SampleParagraph;
import com.intelliment.util.CounterApiUtil;


@Service
public class SearchParagraphService implements SearchParagraghServiceInterface{
	
	public SearchParagraphService() {
		
	}
	
	public SampleParagraph getParagraphApi()
	{
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add(
				  new BasicAuthorizationInterceptor("user1", "user1Pass"));
		return restTemplate.getForObject("http://localhost:8071/RestServiceCounterApi/paragraph/getText", SampleParagraph.class);
	}
	

	public Map<String,Integer> GetTop(int n)
	{
		Map<String,Integer> top = ConstructParagraphToWordMap();
	    top = CounterApiUtil.getTopNWords(top,n);
	    return top;
		
	}
	
	private Map<String,Integer> ConstructParagraphToWordMap(){
		Map<String,Integer> top = new HashMap<String,Integer>();
		SampleParagraph para  = getParagraphApi();
		String paraStr = para.getParagraphText();
		
		StringTokenizer st = new StringTokenizer(paraStr);
		
	    while (st.hasMoreTokens()) {
	    	String tempStr = st.nextToken().toLowerCase();
	    	tempStr = tempStr.replaceAll("[^a-zA-Z0-9]", "");
	    	if(top.containsKey(tempStr)) {
	    		top.put(tempStr, top.get(tempStr) + 1);
	    	}
	    	else {
	    		top.put(tempStr, 1);
	    	}
	    }
	    return top;
	}
	
	public HashMap<String,Integer> SearchStringCount(String[] str)
	{
		HashMap<String,Integer> strCount = new HashMap<String,Integer>();
		Map<String,Integer> top = ConstructParagraphToWordMap();
		for (String string : str) {
			
			if(top.containsKey(string.toLowerCase())) {
				strCount.put(string, top.get(string.toLowerCase()));
			}else {
				strCount.put(string, 0);
			}
			
		}
		return strCount;
	}
}
