package com.testpractice.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public WebDriver createBrowserInstance(String browser) {
		WebDriver driver = null;
		if(browser.equalsIgnoreCase("Chrome")) {
			//Download chromeDriver Jar
			WebDriverManager.chromedriver().setup();  
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}
		
		if(browser.equalsIgnoreCase("Firefox")) {
			//Download FireFoxDriver Jar
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions fOptions = new FirefoxOptions();
			fOptions.addArguments("-private");
			driver = new FirefoxDriver(fOptions);
		}
		
		if(browser.equalsIgnoreCase("Internet Explorer")) {
			//Download IEDriver Jar
			WebDriverManager.iedriver().setup();
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.addCommandSwitches("-private");
			driver = new InternetExplorerDriver(ieOptions);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		return driver;
	}

}
