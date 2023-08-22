package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTesting2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver wb = new ChromeDriver();
		wb.get("https://www.amazon.in/ref=nav_logo");
		WebElement we =wb.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		//List<WebElement> allLinks = we.findElements(By.tagName("option"));
		Select se = new Select(we);
		//getOptions():List<WebElement>;
		List<WebElement> allItems=se.getOptions();
		System.out.println(allItems.size());
		for(int i=0;i<allItems.size();i++) {
			System.out.println(allItems.get(i).getText());
		}
		
wb.quit();
	}

}
