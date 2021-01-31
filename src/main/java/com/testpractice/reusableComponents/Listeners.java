package com.testpractice.reusableComponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testpractice.testBase.DriverFactory;
import com.testpractice.testBase.ExtentFactory;

public class Listeners extends ObjectRepo implements ITestListener{
	
	ExtentReports extent;
	
	@Override
	public void onTestStart(ITestResult result) {
		//Create extent test with every test
		extentTest = extent.createTest(result.getMethod().getMethodName());
		ExtentFactory.getExtentInstance().setExtent(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentFactory.getExtentInstance().getExtent().log(Status.PASS,"Test Case"+result.getMethod().getMethodName()+" has Passed");
		ExtentFactory.getExtentInstance().removeExtentThread();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentFactory.getExtentInstance().getExtent().log(Status.FAIL,"Test Case"+result.getMethod().getMethodName()+" has Failed");
		ExtentFactory.getExtentInstance().getExtent().log(Status.FAIL, result.getThrowable());
		
		File src = ((TakesScreenshot)DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir")+"/reports/Screenshots/Screenshot.jpeg";
		File dest = new File(filePath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ExtentFactory.getExtentInstance().getExtent().addScreenCaptureFromPath(filePath, "Failure SCreenshot");
			ExtentFactory.getExtentInstance().removeExtentThread();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		//Before running all test methods call extentReports
		extent = ExtentSetup.setupExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		//After running all test methods flush reports
		extent.flush();
	}

}
