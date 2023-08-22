package automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropOnECsIte {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://emicalculator.net/");
	driver.manage().window().maximize();
	
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		
	}
	@Test
	public void dragTheButton() {
	
		Actions act = new Actions(driver);
		act.dragAndDropBy(driver.findElement(By.xpath("(//span[@tabindex='0'])[1]")), 80, 0)
		.pause(Duration.ofSeconds(4))
        .dragAndDropBy(driver.findElement(By.xpath("(//span[@tabindex='0'])[2]")), 150, 0)
		.pause(Duration.ofSeconds(4))
		
		.dragAndDropBy(driver.findElement(By.xpath("(//span[@tabindex='0'])[3]")), -107, 0)
		.build()
		.perform();
		WebElement element=driver.findElement(By.xpath("//div[@id='emiamount']/descendant::span"));
		
		Assert.assertEquals(element.getText(),"92,439");
		System.out.println(element.getText());
		
		
		
	}

}
