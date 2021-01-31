package com.testpractice.testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	private DriverFactory() {
		
	}
	
	static DriverFactory instance = new DriverFactory();;
	
	public static DriverFactory getInstance() {
		return instance;
	}
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	WebDriver driverInstance;
	public void setDriver(WebDriver driverInstance) {
		this.driverInstance = driverInstance;
		System.out.println("Set Driver Instance" + this.driverInstance);
		driver.set(driverInstance);
	}
	
	public WebDriver getDriver() {
		System.out.println("Get Driver Instance" + this.driverInstance);
		return driver.get();
	}
	
	public void closeBrowser() {
		driver.get().close();
		driver.remove();
	}
}
