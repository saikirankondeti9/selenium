package automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://echoecho.com/htmlforms09.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test 
	public void checkBoxes1() throws InterruptedException {
		//WebElement table=driver.findElement(By.xpath(""));
		List<WebElement> cBoxes=driver.findElements(By.xpath("//td[@class='table5']/child::input"));
		for(WebElement cBox:cBoxes) {
			if(!cBox.isSelected()) {
				cBox.click();
				Thread.sleep(4000);
			}
		}
		
	}

}
