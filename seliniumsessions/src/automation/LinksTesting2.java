package automation;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksTesting2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver dr = new ChromeDriver();
		dr.get("https://www.icicibank.com/personal-banking/insta-banking/internet-banking");
		dr.manage().window().maximize();
		WebElement ge = dr.findElement(By.xpath("//img[@src='/content/dam/icicibank/india/managed-assets/images/corporate/white_close-icon.svg\']"));
		ge.click();
		WebElement bl = dr.findElement(By.xpath("//h5[text()='POPULAR PRODUCTS']/parent::div"));
		List<WebElement> allLinks = bl.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		for(int i=0;i<allLinks.size();i++) {
			WebElement link = allLinks.get(i);
			System.out.println(link.getText());
			System.out.println(link.getAttribute("href"));
			JavascriptExecutor jse=(JavascriptExecutor) dr;
			//jse.executeScript("arguments[0].click();",link);
			jse.executeScript("window.scrollBy(0,4000);");
			Thread.sleep(2000);
			link.click();
			System.out.println(dr.getCurrentUrl());
			dr.navigate().back();
			Thread.sleep(2000);
			try
			{
				Thread.sleep(2000);
				dr.findElement(By.xpath("//img[@src='/content/dam/icicibank/india/managed-assets/images/corporate/white_close-icon.svg\']")).click();
			}
			catch(Exception e) {
				
			}
			Thread.sleep(1000);
			jse.executeScript("window.scrollBy(0,-6000);");
			// ge = dr.findElement(By.xpath("//img[@src='/content/dam/icicibank/india/managed-assets/images/corporate/white_close-icon.svg\']"));
			bl = dr.findElement(By.xpath("//h5[text()='POPULAR PRODUCTS']/parent::div"));
			allLinks = bl.findElements(By.tagName("a"));
			Thread.sleep(2000);
			
			
			
		}
		
		dr.quit();
	}
}

