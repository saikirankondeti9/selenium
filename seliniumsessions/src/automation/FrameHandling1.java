package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling1 {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void framesHandling() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
			Actions act = new Actions(driver);
			act.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")),driver.findElement(By.xpath("//div[@id='droppable']")) ).build().perform();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//a[text()='Sortable']")).click();
	
			
	}

}
