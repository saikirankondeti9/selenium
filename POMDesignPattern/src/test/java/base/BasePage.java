package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public static WebDriver driver;
	public static Properties configProp;
	public  FileInputStream fIS1;
	//public static FileInputStream fIS2;
	
	
	@BeforeTest
	public void fileSetUp() throws IOException {
		fIS1=new FileInputStream("src\\test\\resources\\properties\\config.properties");
		configProp= new Properties();
		configProp.load(fIS1);
		
	}
	@BeforeMethod
	public void browserAndAppsetUp() {
		String browserName=configProp.getProperty("browser");
		switch(browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
			
		}
		driver.get(configProp.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitwait"))));
		//driver.manage().timeouts().implicitlyWait(Long.parseLong(configProp.getProperty("implicitwait")), TimeUnit.SECONDS);
		
		
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
