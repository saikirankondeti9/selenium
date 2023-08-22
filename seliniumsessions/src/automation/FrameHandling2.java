package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling2  {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	@Test
public void printingTheLinksInTheFrame() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='overview-frame.html']")));
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		for(WebElement all:allLinks) {
			System.out.println(all.getText());
		}
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='overview-summary.html']")));
		List<WebElement> allLinks1=driver.findElements(By.tagName("a"));
		System.out.println(allLinks1.size());
		for(WebElement alll:allLinks1) {
			System.out.println(alll.getText());}
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='allclasses-frame.html']")));
		List<WebElement> allLinks2=driver.findElements(By.tagName("a"));
		System.out.println(allLinks2.size());
		for(WebElement allll:allLinks2) {
			System.out.println(allll.getText());}
	} 
	}

