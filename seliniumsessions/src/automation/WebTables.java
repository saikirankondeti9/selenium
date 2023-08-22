package automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTables {
	public class RadioButtons {
		WebDriver driver;
		@BeforeMethod
		public void setUp() {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://www.timeanddate.com/worldclock/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		/*	
			/html/body/div[5]/section[1]/div/section/div[1]/div//table/tbody/tr[2]/td[1]/a
			 
			 */
		}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test
	public void webtablesTesting() {
		String part1="//table/tbody/tr[";
		String part2="]/td[1]/a";
		for (int i=1;i<36;i++) {
			System.out.println(driver.findElement(By.xpath(part1+i+part2)).getText());
		}
		
		
	}
	}

}
