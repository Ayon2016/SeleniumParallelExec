package PageObjectsSpecific;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.testpractice.reusableComponents.BasePage;
import com.testpractice.testBase.ExtentFactory;

public class UnitedFlight extends BasePage{
//Website https://www.united.com/en/us
//To test AutoSuggestive Dropdowns
	private By TxtBox_FromLocation = By.xpath("//input[@id='bookFlightOriginInput']");
	private By Btn_Remove = By.xpath("//input[@id='bookFlightOriginInput']/preceding-sibling::button");
	
	public void clickOnFromTextBox() {
		Click(TxtBox_FromLocation, "From Destination");
	}
	
	public void clickOnRemoveButton() {
		Click(Btn_Remove, "Remove Button");
	}
	
	public void EnterTextonFrom(String fromDestination) {
		Type(TxtBox_FromLocation,fromDestination,"Destination");
	}
	
	public boolean SelectAutoSuggestive(String destinationToSelect) throws Exception {
		boolean result = false;
		String xpath = "//ul[@id='bookFlightOriginInput-menu']/li/button/div";
		List<WebElement> elements = GetListofWebElementsByXpath(xpath);
		if(elements==null) {
			throw new Exception("Elements not found");
		}
		for(WebElement e: elements) {
			if(e.getText().contains(destinationToSelect)){
				e.click();
				result = true;
				break;
			}
		}
		return result;
	}
}
