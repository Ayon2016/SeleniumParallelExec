package com.testpractice.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testpractice.testBase.TestBase;

public class WindowsAuth extends TestBase{
	
	//https://admin:admin@the-internet.herokuapp.com/basic_auth
	
	@Test(enabled=true)
	public void VerifyWindowsAuth() throws InterruptedException {
		hero.ClickOnBasicAuthLink();
		String Actual = auth.getSuccessAuthMessage().trim();
		String Expected = "Congratulations! You must have the proper credentials.";
		Assert.assertEquals(Actual, Expected);
	}

}
