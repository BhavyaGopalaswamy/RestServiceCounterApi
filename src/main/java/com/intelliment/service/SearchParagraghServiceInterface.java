package com.intelliment.service;

import java.util.HashMap;
import java.util.Map;

public interface SearchParagraghServiceInterface {
	
	public Map<String,Integer> GetTop(int n);
	
	public HashMap<String,Integer> SearchStringCount(String[] str);
	
}
