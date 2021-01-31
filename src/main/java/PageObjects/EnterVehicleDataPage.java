package PageObjects;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;
import com.testpractice.reusableComponents.BasePage;

public class EnterVehicleDataPage extends BasePage{

	private By TxtBox_Engine_Performance = By.xpath("//input[@id='engineperformance']");
	private By error_Engine_Performance = By.xpath("//input[@id='engineperformance']/following-sibling::span[@class='error']");
	private By Dropdown_Make = By.xpath("//Select[@id='make']");
	private By Dropdown_Model= By.xpath("//Select[@id='model']");
	private By TxtBox_Cylinder_Capacity = By.xpath("//input[@id='cylindercapacity']");
	private By DatePicker_Date_of_Manufacture = By.xpath("//input[@id='dateofmanufacture']");
	private By DropDown_NumberofSeats = By.xpath("//Select[@id='numberofseatsmotorcycle']");
	private By TxtBox_ListPrice = By.xpath("//input[@id='listprice']");
	private By TxtBox_Annual_Mileage = By.xpath("//input[@id='annualmileage']");
	private By Btn_Next = By.xpath("//button[@id='nextenterinsurantdata']");
	
	//dateofmanufacture
	public void EnterEnginePerformance(String cylinderCapacity) {
		Type(TxtBox_Engine_Performance,cylinderCapacity,"Engine Performance Textbox");
	}
	
	public String getEnginePerformanceErrorText() throws InterruptedException {
		return GetTextFromElement(error_Engine_Performance, "Performance Error Message");
	}
	
	public List<String> getMakeDropdownValues(){
		return GetDropdownOptionsforSelect(Dropdown_Make, "Make Dropdown");
	}
	
	public void enterVehicleData(HashMap<String,String> testDataMap) {
		extentTest.log(Status.INFO, "Test Data - "+ testDataMap);
		SelectByVisibleText(Dropdown_Make, testDataMap.get("Vehicle_Make"));
		SelectByVisibleText(Dropdown_Model, "Motorcycle");
		Type(TxtBox_Cylinder_Capacity, "6", "Cylinder Capacity");
		Type(TxtBox_Engine_Performance, "700", "Engine Performance");
		Type(DatePicker_Date_of_Manufacture, "07/01/2019", "Date of Manufacture");
		SelectByVisibleText(DropDown_NumberofSeats, "2");
		Type(TxtBox_ListPrice, "07/01/2019", "Date of Manufacture");
		Type(TxtBox_Annual_Mileage, "123", "Date of Manufacture");
		Click(Btn_Next, "Next Button");
	}
}
