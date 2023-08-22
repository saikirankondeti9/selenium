package automation;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTesting3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.flipkart.com/");
		dr.manage().window().maximize();
		WebElement gd = dr.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		gd.click();
		WebElement bl = dr.findElement(By.xpath("//div[text()='CONSUMER POLICY']/parent::div"));
		List<WebElement> allLinks = bl.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		for (int i = 0; i < allLinks.size(); i++) {
			WebElement link = allLinks.get(i);
			System.out.println(link.getText());
			//JavascriptExecutor js=(JavascriptExecutor) dr;
			//js.executeScript("window.scrollTo(0,3000);");
			link.click();
			Thread.sleep(5000);
			System.out.println(dr.getCurrentUrl());
			dr.navigate().back();
			Thread.sleep(5000);
			bl = dr.findElement(By.xpath("//div[text()='CONSUMER POLICY']/parent::div"));
			allLinks = bl.findElements(By.tagName("a"));
			Thread.sleep(3000);
			

		}
		dr.quit();
	}
}
