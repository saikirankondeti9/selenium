package automation;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling2 {
	
	WebDriver driver;
	ChromeOptions opt;
	@BeforeTest
	public void setUp() {
		opt=new ChromeOptions();
		opt.addExtensions(new File("./Extensions/AdBlock.crx") );
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver(opt);
		driver.get("https://demo.guru99.com/V4/");
		driver.manage().window().maximize();
	}
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void alHOnGuru() throws InterruptedException {
		driver.findElement(By.xpath("//input[@onkeyup='validateuserid();']")).sendKeys("mngr266311");
		Thread.sleep(2000);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.switchTo().activeElement().sendKeys("Admin123$");
		Thread.sleep(2000);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.switchTo().activeElement().click();
		String windo=driver.getWindowHandle();
		driver.switchTo().window(windo);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Delete Customer']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@onkeyup='validatecustomerid();']")).sendKeys("saiki123");
		Thread.sleep(2000);
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		Thread.sleep(2000);
		driver.switchTo().activeElement().click();
		Alert alr=driver.switchTo().alert();
		Assert.assertEquals(alr.getText(), "Please fill all fields");
		alr.accept();
		
		
		
		
	}
	

}
