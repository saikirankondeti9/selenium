package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownTesting3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver wb = new ChromeDriver();
		wb.get("https://www.amazon.in/ref=nav_logo");
		wb.findElement(By.xpath("//select[@id='searchDropdownBox']")).sendKeys("Electronics");
		System.out.println(wb.findElement(By.xpath("//option[text()='Books']")).isSelected());
		System.out.println(wb.findElement(By.xpath("//option[text()='Electronics']")).isSelected());
		// List<WebElement> allLinks = we.findElements(By.tagName("option"));
		// Select se = new Select(we);
		// getOptions():List<WebElement>;
		// List<WebElement> allItems=se.getOptions();
		// System.out.println(allItems.size());
		// for(int i=0;i<allItems.size();i++) {
		// System.out.println(allItems.get(i).getText());

		wb.quit();
	}

}
