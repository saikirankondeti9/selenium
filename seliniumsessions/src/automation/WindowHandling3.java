package automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling3 {
	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.livetech.in/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void wHTOLiveTEchWeb() throws InterruptedException {
		// to get the window id
		String hWId = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[contains(@href,'www.facebook.com')]")).click();
		Thread.sleep(2000);

		switchToWindow("LiveTech | Facebook");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Create new account']")).click();
		Thread.sleep(2000);

		driver.switchTo().window(hWId);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[contains(@href,'www.linkedin.com')]")).click();
		Thread.sleep(2000);

		switchToWindow("LiveTech QA - Andhra Pradesh, India | Professional Profile | LinkedIn");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[contains(@data-modal,'public_profile_contextual')]")).click();
		Thread.sleep(2000);
		
		driver.switchTo().window(hWId);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(@href,'www.instagram.com')]")).click();
		Thread.sleep(2000);
		
		switchToWindow("LiveTech Testingtools (@livetechqa) | Instagram");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Sign Up']")).click();
		
		driver.switchTo().window(hWId);

	}

	private void switchToWindow(String exptitle) throws InterruptedException {
		Set<String> wIds = driver.getWindowHandles();
		Iterator<String> it = wIds.iterator();
		while (it.hasNext()) {
			String wId = it.next();
			driver.switchTo().window(wId);
			Thread.sleep(2000);
			if (driver.getTitle().equals(exptitle)) {

				break;

			}

		}

	}

}
