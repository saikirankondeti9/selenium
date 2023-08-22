package automation;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BrowserLaunch {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@href='/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles']")).click();
		Thread.sleep(10000);
		driver.quit();
		
	}

}
