package com.testpractice.testBase;

import java.util.HashMap;

public class RowMapFactory {
	
	private RowMapFactory() {
		
	}
	static RowMapFactory instance = new RowMapFactory();
	ThreadLocal<HashMap<String,String>> rowMap = new ThreadLocal<HashMap<String,String>>();
	
	public static RowMapFactory getInstance() {
		return instance;
	}
	
	public HashMap<String,String> getTestDataMap() {
		return rowMap.get();
	}
	
	public void setTestDataMap(HashMap<String,String> testData) {
		rowMap.set(testData);
	}

}
