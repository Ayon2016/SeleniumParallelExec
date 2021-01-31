package PageObjects;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testpractice.reusableComponents.BasePage;

public class TableSortAndSearchPage extends BasePage{
	
	public List<String> getTableElementsByColumn(String columnName){
		String xpath = "//tbody/tr/td[count(//thead/tr/th[contains(text(),'"+columnName+"')]/preceding-sibling::th)+1]";
		List<WebElement> elementList = GetTableRowElementsByColumn(By.xpath(xpath), "Get all Elements for that Column");
		List<String> elementName = new ArrayList<String>();
		for(WebElement e: elementList) {
			System.out.println(e.getText());
			elementName.add(e.getText());
		}
		return elementName;
	}
}
