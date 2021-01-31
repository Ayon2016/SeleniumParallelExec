package PageObjectsSpecific;

import org.openqa.selenium.By;

import com.testpractice.reusableComponents.BasePage;

public class BasicAuthHeroKu extends BasePage{
	
	private By Txt_ProperCredentials_Message = By.xpath("//p[contains(text(),'Congratulations')]");
	
	public String getSuccessAuthMessage() throws InterruptedException {
		String text = GetTextFromElement(Txt_ProperCredentials_Message,"Success Text");
		return text;
	}

}
