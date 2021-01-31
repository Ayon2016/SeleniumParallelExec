package com.testpractice.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testpractice.reusableComponents.ExcelOperations;
import com.testpractice.testBase.BrowserFactory;
import com.testpractice.testBase.DriverFactory;
import com.testpractice.testBase.TestBase;

public class AutoSuggestiveTest extends TestBase{
	
	ExcelOperations excel = new ExcelOperations("AutoSuggestive");
	
	@Test(dataProvider="united")
	public void AutoSuggestiveDropdown(HashMap<String,String> map) throws Exception {
		united.clickOnFromTextBox();
		united.clickOnRemoveButton();
		united.EnterTextonFrom(map.get("From"));
		boolean result = united.SelectAutoSuggestive(map.get("FromDestinationToSelect"));
		Assert.assertTrue(result);
	}
	
	@DataProvider(name="united")
	public Object[][] testData() throws EncryptedDocumentException, IOException{
		Object[][] obj = new Object[excel.getNumRows()][1];
		for(int i=0;i<=excel.getNumRows()-1;i++) {
			obj[i][0] = excel.getTestDatainMap(i+1);
		}
		return obj;
	}

}
