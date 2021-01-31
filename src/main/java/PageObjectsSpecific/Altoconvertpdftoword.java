package PageObjectsSpecific;

import org.openqa.selenium.By;

import com.testpractice.reusableComponents.BasePage;

public class Altoconvertpdftoword extends BasePage {
//URL: https://altoconvertpdftoword.com/
	private By Btn_Upload = By.xpath("//span[contains(text(),'Choose File')]/ancestor::button");
	
	public void clickOnUploadButton() {
		Click(Btn_Upload,"Upload Button");
	}

}
