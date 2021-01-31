package PageObjects;

import org.openqa.selenium.By;

import com.testpractice.reusableComponents.BasePage;

public class DemoAppHomePage extends BasePage {
	
	private By Link_Other_Web_Elements = By.xpath("//div[@class='main-navigation']/ul/li[2]/a[contains(text(),'Other Web-Elements')]");
	private By Link_More_Web_Elements = By.xpath("//div[@class='main-navigation']/ul/li[3]/a[contains(text(),'More Web Elements')]");
	
	public void navigateToOtherWebElements() {
		Click(Link_Other_Web_Elements,"Other WebElements Link");
	}

}
