package PageObjects;

import org.openqa.selenium.By;

import com.testpractice.reusableComponents.BasePage;

public class HomePage extends BasePage{
	
	private By Tab_Automobile = By.xpath("//button[@class='menu-toggle']/following-sibling::ul/li[1]/a[@id='nav_automobile']");
	private By Tab_Truck = By.xpath("//button[@class='menu-toggle']/following-sibling::ul/li[2]/a[@id='nav_truck']");
	private By Tab_Motorcycle = By.xpath("//button[@class='menu-toggle']/following-sibling::ul/li[3]/a[@id='nav_motorcycle']");
	
	public void ClickAutomobileTab() {
		System.out.println("On Click Automobile Tab");
		Click(Tab_Automobile,"Automobile Tab");
	}
	
	public void ClickOnMotocycleTab() {
		System.out.println("On Click Automobile Tab");
		Click(Tab_Motorcycle,"Automobile Tab");
	}
	
}
