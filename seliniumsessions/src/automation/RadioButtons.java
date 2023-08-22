package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtons {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://echoecho.com/htmlforms10.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
@AfterMethod
public void tearDown() {
	driver.quit();
}
@Test
public void radioButtonTesting() throws InterruptedException {
	driver.findElement(By.xpath("//input[@value='Milk']")).click();
	Thread.sleep(3000);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@value='Milk']")).isSelected(),true);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@value='Butter']")).isSelected(),false);
	Assert.assertEquals(driver.findElement(By.xpath("//input[@value='Cheese']")).isSelected(),false);
	}

}
