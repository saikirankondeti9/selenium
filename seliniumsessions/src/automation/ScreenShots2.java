package automation;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShots2 {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void takeScreenshotWithTime() throws IOException {
		Date d=new Date();
		String pattern="yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sDF = new SimpleDateFormat(pattern);
	String date=sDF.format(d);
	date=date.replace(":", "-");
	File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcFile, new File("ada"+date+".png"));
		
	} 

}
