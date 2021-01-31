package PageObjects;

import org.openqa.selenium.By;

import com.testpractice.reusableComponents.BasePage;

public class DempAppOtherWebElementsPage extends BasePage{
	private By Link_Frames = By.xpath("//a[contains(text(),'frames')]");
	private By IFrame_Locator = By.xpath("//iframe[@id='frame3']");
	private By CheckBox_InnerFrame_ChkBox = By.xpath("//input[@id='a']");
	
	public void clickFramesLink() {
		Click(Link_Frames,"Frames Link");
	}
	
	public void clickFrameCheckBox() {
		NavigateToIFrame(IFrame_Locator,"IFrame Locator");
		Click(CheckBox_InnerFrame_ChkBox,"Inner Frame CheckBox");
		NavigateToDefault();
	}
}
