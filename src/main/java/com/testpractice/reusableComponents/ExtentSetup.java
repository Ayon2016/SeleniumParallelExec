package com.testpractice.reusableComponents;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentSetup {
	
	public static ExtentReports setupExtentReport() {
		SimpleDateFormat sdf = new SimpleDateFormat("mm-dd-yyyy HH:mm:ss");
		Date date = new Date();
		String dateRep = sdf.format(date);
		String path = System.getProperty("user.dir")+"/reports/ExecutionResults_"+dateRep+".html";
		//Create Report ExtentSparkReporter(File path)
		ExtentSparkReporter sparkReport = new ExtentSparkReporter(path);
		sparkReport.config().setDocumentTitle("PracticeTest Report");
		sparkReport.config().setTheme(Theme.DARK);
		
		//Create Object of Extent Reports and attach report
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		return extent;
		
	}
	


}
