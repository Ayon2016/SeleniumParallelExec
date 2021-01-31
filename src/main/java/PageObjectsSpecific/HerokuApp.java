package PageObjectsSpecific;

import org.openqa.selenium.By;

import com.testpractice.reusableComponents.BasePage;

public class HerokuApp extends BasePage{
	
	private By Link_BasicAuth = By.xpath("//a[contains(text(),'Basic Auth')]");
	
	public void ClickOnBasicAuthLink() {
		Click(Link_BasicAuth,"Basic Auth Link");
	}

}
