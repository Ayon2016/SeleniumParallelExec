package com.testpractice.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testpractice.reusableComponents.ExcelOperations;
import com.testpractice.testBase.TestBase;

public class EndToEndTest extends TestBase{
	
	ExcelOperations excel = new ExcelOperations("Test Data");

	@Test(dataProvider="vehData", enabled=false)
	public void enterMotorcycleVehicleData(HashMap<String,String> testDataMap) {
		//HashMap<String,String> testDataMap = (HashMap<String, String>) obj;
//		System.out.println(testDataMap);
		homePage.ClickOnMotocycleTab();
		vehData.enterVehicleData(testDataMap);
		String actual = insData.verifyEnterInsurantTabisActive();
		Assert.assertEquals(actual, "idealsteps-step-active");
	}
	
	@DataProvider(name="vehData")
	public Object[][] getTestData() throws EncryptedDocumentException, IOException{
		System.out.println("I am in dataProvider");
		Object[][] obj = new Object[excel.getNumRows()][1];
		
		for(int i=0;i<=excel.getNumRows()-1;i++) {
			HashMap<String,String> testData = excel.getTestDatainMap(i+1);
			obj[i][0] = testData;
		}
		return obj;
		
	}
}
