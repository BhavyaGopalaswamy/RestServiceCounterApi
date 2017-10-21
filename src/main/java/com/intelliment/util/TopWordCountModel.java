package com.intelliment.util;

public class TopWordCountModel {

	String word;
	int count;

	public TopWordCountModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TopWordCountModel(String word,int count) {
		super();
		this.word = word;
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
