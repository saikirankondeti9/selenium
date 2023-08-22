package automation;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHovering2 {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void mouseHoverInDemo() throws InterruptedException {
		
		Thread.sleep(3000);

		
		Actions act=new Actions(driver);
		
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Laptops & Notebooks']")))
		   .pause(3000)
		   .moveToElement(driver.findElement(By.xpath("//a[text()='Show All Laptops & Notebooks']")))
		   .click()
		   .pause(3000)
		   .build().perform();
		
		/*
		 * act.moveToElement(driver.findElement(By.
		 * xpath("//a[text()='Laptops & Notebooks']"))) .pause(Duration.ofSeconds(4))
		 * .click((driver.findElement(By.
		 * xpath("//a[text()='Show All Laptops & Notebooks']"))))
		 * .pause(Duration.ofSeconds(4)) .build().perform();
		 */
		List<WebElement> wBES=driver.findElements(By.className("product-thumb"));
		System.out.println(wBES.size());
		for(WebElement wb:wBES) {
			System.out.println(wb.getText());
			
		}
		
		
	}

}
