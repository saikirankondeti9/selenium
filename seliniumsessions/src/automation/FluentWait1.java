package automation;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWait1 {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
@AfterMethod
public void tearDown() {
	driver.quit();
}
@Test
public void waitsTesting() {
	driver.findElement(By.xpath("//span[text()='5']")).click();
	driver.findElement(By.xpath("//span[text()='+']")).click();
	driver.findElement(By.xpath("//span[text()='5']")).click();
	driver.findElement(By.xpath("//span[text()='=']")).click();
	//WebDriverWait myWait=new WebDriverWait(driver,20);
	FluentWait<WebDriver> myWait=new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofMillis(300))
			.ignoring(NoSuchElementException.class);
	myWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@id='spinner']")));
	Assert.assertEquals(driver.findElement(By.xpath("//div[@class='screen']")).getText(), "10");
	System.out.println(driver.findElement(By.xpath("//div[@class='screen']")).getText());
}
}



