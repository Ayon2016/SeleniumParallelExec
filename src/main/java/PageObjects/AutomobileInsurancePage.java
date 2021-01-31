package PageObjects;

import org.openqa.selenium.By;

import com.testpractice.reusableComponents.BasePage;

public class AutomobileInsurancePage extends BasePage{
	private By Tab_EnterVehicleData = By.xpath("//a[contains(text(),'Enter Vehicle Data')]");
	private By Tab_EnterInsurantData = By.xpath("//a[contains(text(),'Enter Insurant Data')]");
	
	public void clickonEnterVehicleDataTab() {
		Click(Tab_EnterVehicleData,"Enter Vehicle Data Tab");
	}
}
