package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTesting1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.amazon.in/ref=nav_logo");
		dr.manage().window().maximize();
		WebElement bl = dr.findElement(By.xpath("//div[text()='Make Money with Us']/parent::div"));
		List<WebElement> allLinks = bl.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		for (int i = 0; i < allLinks.size(); i++) {
			WebElement link = allLinks.get(i);
			System.out.println(link.getText());
			link.click();
			Thread.sleep(5000);
			System.out.println(dr.getCurrentUrl());
			dr.navigate().back();
			Thread.sleep(5000);
			bl = dr.findElement(By.xpath("//div[text()='Make Money with Us']/parent::div"));
			allLinks = bl.findElements(By.tagName("a"));
			Thread.sleep(3000);
			

		}
		dr.quit();
	}
}
