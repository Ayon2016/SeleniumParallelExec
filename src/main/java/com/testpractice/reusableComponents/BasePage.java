package com.testpractice.reusableComponents;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.testpractice.testBase.DriverFactory;
import com.testpractice.testBase.ExtentFactory;

public class BasePage extends ObjectRepo{
	
	public void NavigateToPage(String url) {
		DriverFactory.getInstance().getDriver().get(url);
		//driver.get("http://userName:Passoword@url") - If Windows Auth
	}
	
	public String GetPageTitle() {
		return DriverFactory.getInstance().getDriver().getTitle();
	}
	
	public void Click(By locator, String locatorDecsription) {
		System.out.println("I am on Click in Base Page");
		boolean isElementPresent = WaitForElementPresent(locator);
		if(isElementPresent) {
			DriverFactory.getInstance().getDriver().findElement(locator).click();
			extentTest.log(Status.PASS,"Click Successful on locator" + locatorDecsription);
		}
		else {
			System.out.println("The locator" + locatorDecsription+" is not displayed");
			extentTest.log(Status.FAIL,"Click Not Successful on locator" + locatorDecsription);
		}
	}
	
	public boolean Type(By locator, String text, String locatorDesc) {
		boolean isElementPresent = WaitForElementPresent(locator);
		boolean flag = false;
		if(isElementPresent) {
			DriverFactory.getInstance().getDriver().findElement(locator).clear();
			DriverFactory.getInstance().getDriver().findElement(locator).sendKeys(text);
			flag = true;
			System.out.println("Type successful on "+ locatorDesc);
		}
		else {
			System.out.println("Type unsuccessful on "+ locatorDesc+". No Element Present");
		}
		return flag;
	}
	
	public String GetTextFromElement(By locator, String locatorDesc) throws InterruptedException {
		boolean isElementPresent = WaitForElementPresent(locator);
		String text = null;
		if(isElementPresent) {
			Thread.sleep(1000);
			text = DriverFactory.getInstance().getDriver().findElement(locator).getText();
			System.out.println("Text Extracted from Element" + locatorDesc+ " Successfully");
		}
		else {
			System.out.println("Element through Locator " + locatorDesc + " Not Present");
		}
		
		return text;
	}
	
	//Get all Options from Select List Using getOptions()
	public List<String> GetDropdownOptionsforSelect(By locator, String locatorDesc){
		boolean flag = WaitForElementPresent(locator);
		List<String> values = null;
		if (flag) {
			WebElement selectList = DriverFactory.getInstance().getDriver().findElement(locator);
			Select sel = new Select(selectList);
			List<WebElement> options = sel.getOptions();
			values = new ArrayList<String>();
			for(WebElement e: options) {
				values.add(e.getText());
			}
			extentTest.log(Status.PASS, "The Select values for locator " + locatorDesc+ " have been returned");
		}
		else {
			extentTest.log(Status.FAIL, "The Select values for locator " + locatorDesc+ " have not been returned");
		}
		return values;
	}
	
	public boolean SelectByVisibleText(By locator, String valueToBeSelected) {
		boolean flag = false;
		boolean res= WaitForElementPresent(locator);
		if(res) {
			Select sel = new Select(DriverFactory.getInstance().getDriver().findElement(locator));
			try {
				sel.selectByVisibleText(valueToBeSelected);
				flag = true;
				extentTest.log(Status.PASS,"The Text: "+ valueToBeSelected+ " has been Selected");
			}
			catch(Exception e) {
				extentTest.log(Status.FAIL, "The Text: "+valueToBeSelected+" could not be selected due to "+ e);
			}
		}
		else {
			extentTest.log(Status.FAIL,"The Text: "+ valueToBeSelected+ " has not been Selected. Element not found");
		}
		
		return flag;
	}
	
	public boolean selectRadioButtonByValue(By locator, String valuetoSelect, String locatorDesc) {
		boolean flg = false;
		boolean res = WaitForElementPresent(locator);
		if(res){
			try {
				List <WebElement> elements = DriverFactory.getInstance().getDriver().findElements(locator);
				for(WebElement e: elements) {
					if(e.getText().equals(valuetoSelect)) {
						e.click();
						flg = true;
						break;
					}
				}
			}
			catch(Exception e) {
				extentTest.log(Status.FAIL, "Radio Button Element "+ valuetoSelect+ " could not be Selected "+ e);
			}
		}
		else {
			extentTest.log(Status.FAIL, "Locator "+ locatorDesc+ " Not found");
		}
		return flg;
	}
	
	public String GetClass(By locator) {
		boolean res= WaitForElementPresent(locator);
		String class_Name = null;
		if(res) {
			class_Name = DriverFactory.getInstance().getDriver().findElement(locator).getAttribute("class");
		}
		
		return class_Name;
	}
	
	public boolean WaitForElementPresent(By locator) {
		boolean flag = false;
		for(int i=0;i<2;i++) {
			if(DriverFactory.getInstance().getDriver().findElements(locator).size()>0) {
				flag = true;
				break;
			}
		}
		
		return flag;
	}
	
	public void NavigateToIFrame(By frameLocator, String Desc) {
		boolean res = WaitForElementPresent(frameLocator);
		if(res) {
			WebElement frameElement = DriverFactory.getInstance().getDriver().findElement(frameLocator);
			DriverFactory.getInstance().getDriver().switchTo().frame(frameElement);
			ExtentFactory.getExtentInstance().getExtent().log(Status.INFO, "Switched to Frame");
		}
		else {
			ExtentFactory.getExtentInstance().getExtent().log(Status.FAIL, "Cannot Switch to Frame");
		}
	}
	
	public void NavigateToDefault() {
		DriverFactory.getInstance().getDriver().switchTo().defaultContent();
	}
	
	//Mouse Action Drag and Drop
	public boolean DragAndDrop(By Source, By Target, String Desc) {
		boolean flg = false;
		if(WaitForElementPresent(Source) && WaitForElementPresent(Target)) {
			Actions action = new Actions(DriverFactory.getInstance().getDriver());
			WebElement source_Element = DriverFactory.getInstance().getDriver().findElement(Source);
			WebElement target_Element = DriverFactory.getInstance().getDriver().findElement(Source);
			action.dragAndDrop(source_Element, target_Element).build().perform();
			flg= true;
		}
		
		return flg;
	}
	
	//Switch to Child Window by number say child# 1 etc..
	public void SwitchToChildWindow(int WindowNum) {
		Set<String> windowId = DriverFactory.getInstance().getDriver().getWindowHandles();
		if(windowId.size()>1) {
			LinkedHashMap<Integer,String> map = new LinkedHashMap<Integer,String>();
			Iterator<String> it = windowId.iterator();
			int count = 0;
			while(it.hasNext()) {
				map.put(count,it.next());
				count++;
			}
			DriverFactory.getInstance().getDriver().switchTo().window(map.get(WindowNum));
		}
	}
	
	public void SwitchToParentWindow() {
		Set<String> windowId = DriverFactory.getInstance().getDriver().getWindowHandles();
		Iterator<String> it = windowId.iterator();
		while(it.hasNext()){
			String parentId = it.next();
			DriverFactory.getInstance().getDriver().switchTo().window(parentId);
			ExtentFactory.getExtentInstance().getExtent().log(Status.INFO, "Switch to Parent Window");
		}
	}
	
	public boolean AcceptAlert() {
		boolean result = false;
		WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),5);
		wait.until(ExpectedConditions.alertIsPresent());
		try {
		DriverFactory.getInstance().getDriver().switchTo().alert().accept();
		result = true;
		ExtentFactory.getExtentInstance().getExtent().log(Status.INFO, "Alert is Accepted");
		}
		catch(Exception e) {
			ExtentFactory.getExtentInstance().getExtent().log(Status.FAIL, "Alert is Not Accepted");
		}
		return result;
	}
	
	public boolean DismissAlert() {
		boolean result = false;
		
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(),5);
			wait.until(ExpectedConditions.alertIsPresent());
			DriverFactory.getInstance().getDriver().switchTo().alert().dismiss();
			result = true;
			ExtentFactory.getExtentInstance().getExtent().log(Status.INFO, "Alert is Dismissed");
		}
		catch(Exception e) {
			ExtentFactory.getExtentInstance().getExtent().log(Status.FAIL, "Alert is Not Dismissed");
		}
		return result;
	}

	
	//This is a custom Method for this DemoPage
	public List<WebElement> GetTableRowElementsByColumn(By locator, String description){
		boolean flg = false;
		if(WaitForElementPresent(locator)) {
			if(DriverFactory.getInstance().getDriver().findElements(locator).size()>0) {
				flg=true;
				ExtentFactory.getExtentInstance().getExtent().log(Status.PASS, "Found Table Elements");
				return DriverFactory.getInstance().getDriver().findElements(locator);
			}
			else {
				ExtentFactory.getExtentInstance().getExtent().log(Status.FAIL, "NOT Found Table Elements");
				return null;
			}
		}
		return null;
	}

	//This is a custom method
	public List<WebElement> GetListofWebElementsByXpath(String xpath){
		boolean res = WaitForElementPresent(By.xpath(xpath));
		if(!res) {
			ExtentFactory.getExtentInstance().getExtent().log(Status.FAIL,"Element not found");
			return null;
		}
		ExtentFactory.getExtentInstance().getExtent().log(Status.INFO,"Returning the List of WebElements");
		return DriverFactory.getInstance().getDriver().findElements(By.xpath(xpath));
	}
}
