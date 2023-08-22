package automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//font[text()='Domestic / NRO / NRE FIXED DEPOSIT RATE']/ancestor::div[@class='rates-header']/following-sibling::div[1]/descendant::td[text()='61 - 89 days']

public class DynamivWebTables {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.timeanddate.com/worldclock/");
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
	Thread.sleep(2000);
	driver.quit();
	}
	@Test
	public void dynamicTables() {
		WebElement table=driver.findElement(By.xpath("//Table[@class='zebra fw tb-theme']/child::tbody"));
		List<WebElement> rows=table.findElements(By.xpath("tr"));
		for(WebElement row:rows) {
			List<WebElement> collumns=row.findElements(By.xpath("td"));
			for(WebElement collumn:collumns ) {
				System.out.print(collumn.getText()+"\t");
			}
			System.out.println();
				
			}
		}
		
		
		
	}

