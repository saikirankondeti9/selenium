package automation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling {
	public class FrameHandling1 {
		WebDriver driver;
		@BeforeMethod
		public void setUp() {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
			driver.manage().window().maximize();
		}
		@AfterMethod
		public void tearDown() throws InterruptedException {
			Thread.sleep(2000);
			driver.quit();
		}
		@Test(priority = 1)
		public void loginNoUsernameNoPasswordTest() {
			driver.findElement(By.xpath("//input[@name='proceed']")).click();
			Alert al= driver.switchTo().alert();
			Assert.assertEquals(al.getText(), "Please enter a valid user name");
			al.accept();
		}
		@Test(priority=2)
		public void loginUsernameNoPasswordTest() {
			driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("saikiran123");
			driver.findElement(By.xpath("//input[@name='proceed']")).click();
			Alert al = driver.switchTo().alert();
			Assert.assertEquals(al.getText(),"Please enter your password");
			al.accept();
			
			
			
		} 
		
		
		}

}
