package PageObjects;

import org.openqa.selenium.By;

import com.testpractice.reusableComponents.BasePage;

public class DemoAppMoreElementsPage extends BasePage{
	private By Link_InputForms=By.xpath("//a[contains(text(),'Input Forms')]");
	private By Link_Table = By.xpath("//b[@class='caret']/ancestor::a[contains(text(),'Table')]");
	private By Link_Table_Sort_Search = By.xpath("//li/a[contains(text(),'Table Sort & Search')]");
	
	public void clickTableSortandSearchLink() {
		Click(Link_Table, "Table Link");
		Click(Link_Table_Sort_Search, "Sort and Search");
	}
}
