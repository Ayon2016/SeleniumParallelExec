package com.testpractice.testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.testpractice.reusableComponents.BasePage;
import com.testpractice.reusableComponents.PropertiesOperations;
import com.testpractice.testBase.BrowserFactory;
import com.testpractice.testBase.DriverFactory;
import com.testpractice.testBase.TestBase;

public class TestCases extends TestBase {
	
	@Test(enabled=false)
	public void Test1() throws InterruptedException {
		homePage.ClickAutomobileTab();
		autoinsurePage.clickonEnterVehicleDataTab();
		vehData.EnterEnginePerformance("111111");
		String actualText = vehData.getEnginePerformanceErrorText();
		String expectedText = "dummy";
		Assert.assertEquals(actualText, expectedText,"The text does not match");
	}
	
	@Test(enabled=false)
	public void Test2() throws InterruptedException {
		homePage.ClickAutomobileTab();
		autoinsurePage.clickonEnterVehicleDataTab();
		vehData.getMakeDropdownValues();
	}
	
}
