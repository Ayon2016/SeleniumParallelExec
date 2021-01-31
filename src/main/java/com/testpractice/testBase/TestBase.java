package com.testpractice.testBase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.testpractice.reusableComponents.BasePage;
import com.testpractice.reusableComponents.ExcelOperations;
import com.testpractice.reusableComponents.PropertiesOperations;

public class TestBase extends BasePage{
	
	@BeforeMethod
	public void Setup() throws EncryptedDocumentException, IOException {
		System.out.println("Setup");
		BrowserFactory bf = new BrowserFactory();
		DriverFactory.getInstance().setDriver(bf.createBrowserInstance("Chrome"));
		NavigateToPage(PropertiesOperations.getProperties("url"));
	}
	
	@AfterMethod
	public void TearDown() {
		DriverFactory.getInstance().closeBrowser();
	}
}
