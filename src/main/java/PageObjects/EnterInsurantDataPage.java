package PageObjects;

import org.openqa.selenium.By;

import com.testpractice.reusableComponents.BasePage;

public class EnterInsurantDataPage extends BasePage{
	
	private By Tab_EnterInsurantData = By.xpath("//a[@id='enterinsurantdata']/ancestor::li[1]");
	
	public String verifyEnterInsurantTabisActive() {
		return GetClass(Tab_EnterInsurantData);
	}
}
