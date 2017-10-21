package com.intelliment.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CounterApiUtil {
	
	public static Map<String,Integer> getTopNWords(Map<String,Integer> mapOfWords,int n){
		Set<String> keySet = mapOfWords.keySet();
		Iterator<String> iterator = keySet.iterator();
		Map<String, Integer> topWords = new HashMap<String, Integer>();
		while(iterator.hasNext()){
			String tempWord = iterator.next();
			Integer tempCount = mapOfWords.get(tempWord);
			if(topWords.size() < n){
				topWords.put(tempWord,tempCount);
			}else{
				topWords = findAndReplaceLeastRepeated(topWords,tempWord,tempCount);
			}
		}
		topWords = sortMap(topWords);
		return topWords;
	}
	
	private static Map<String, Integer> findAndReplaceLeastRepeated(Map<String, Integer> mapOfWords,String newWord,Integer count){
		Integer minCount = Collections.min(mapOfWords.values());
		if(count > minCount){
			Iterator<String> topFiveWordsIterator = mapOfWords.keySet().iterator();
			while(topFiveWordsIterator.hasNext()){
				String tempWordToRemove = topFiveWordsIterator.next();
				if(mapOfWords.get(tempWordToRemove) == minCount){
					mapOfWords.remove(tempWordToRemove);
					break;
				}
			}
			mapOfWords.put(newWord,count);
		}
		return mapOfWords;
	}
	
	private static Map<String, Integer> sortMap(Map<String, Integer> unsortedMap)
    {
        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortedMap.entrySet());
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2)
            {
                    return o2.getValue().compareTo(o1.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

}
