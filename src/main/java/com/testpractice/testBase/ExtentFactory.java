package com.testpractice.testBase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {
	private ExtentFactory() {
		
	}
	
	static ExtentFactory instance = new ExtentFactory();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public static ExtentFactory getExtentInstance() {
		return instance;
	}
	
	public ExtentTest getExtent() {
		return extentTest.get();
	}
	
	public void setExtent(ExtentTest test) {
		extentTest.set(test);
	}
	
	public void removeExtentThread() {
		extentTest.remove();
	}
}
