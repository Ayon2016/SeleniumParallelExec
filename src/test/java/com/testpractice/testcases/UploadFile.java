package com.testpractice.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.testpractice.testBase.TestBase;

public class UploadFile extends TestBase{
	
	@Test(enabled=true)
	public void testUploads() throws IOException, InterruptedException {
		uploadsPage.clickOnUploadButton();
		Thread.sleep(3000);
		try {
			String path = System.getProperty("user.dir")+"\\src\\test\\resources\\FileUploadScript.exe";
			Runtime.getRuntime().exec(path);
		}
		catch(Exception e) {
			
		}
	}

}
