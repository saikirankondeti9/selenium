package automation;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollToDown {
	WebDriver driver;
	WebElement all;
	@BeforeMethod
	public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/V4/");
		driver.navigate().to("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	@Test
	public void scrollDownToView() throws InterruptedException, IOException {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'ads.html')]")));
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
		Set<String> wIDS=driver.getWindowHandles();
		Iterator<String> it=wIDS.iterator();
		while(it.hasNext()) {
			String wID=it.next();
			driver.switchTo().window(wID);
			if(driver.getTitle().equals("Selenium Live Project: FREE Real Time Project for Practice")) {
				break;
			}
		}
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		List<WebElement> webElements=driver.findElements(By.className("kt-infobox-textcontent"));
		System.out.println(webElements.size());
		
		for(WebElement all:webElements) {
			System.out.println(all.isDisplayed());
			Assert.assertEquals(all.isDisplayed(), true);
			System.out.println(all.getText());
			/*File srcFile=all.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("ada.png"));*/
		}
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("ada.png"));
		
	}
	
}
