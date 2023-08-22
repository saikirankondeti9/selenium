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

public class WindowHandling2 {
	WebDriver driver;
	@BeforeMethod
	public void browserSetUp() {
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
	public void multipleWindowHandles() throws InterruptedException {
		String homeWindowid=driver.getWindowHandle();
		System.out.println(homeWindowid);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).click();
		Set<String> windowIds=driver.getWindowHandles();
		Iterator<String> it=windowIds.iterator();
		
		while(it.hasNext()) {
	     String windowId=it.next();
	    // System.out.println(windowId);
			driver.switchTo().window(windowId);
			Thread.sleep(2000);
			if(driver.getTitle().equals("Adactin Hotel App - Apps on Google Play")) {
				break;
			}}
		//switchToWindow("Adactin Hotel App - Apps on Google Play");
		driver.findElement(By.xpath("//span[text()='Games']/ancestor::button")).click();
		Thread.sleep(2000);
		driver.switchTo().window(homeWindowid);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[contains(@src,'ios-button')]")).click();
		windowIds=driver.getWindowHandles();
		 it=windowIds.iterator();
		
		while(it.hasNext()) {
			String windowId1=it.next();
			driver.switchTo().window(windowId1);
			Thread.sleep(2000);
			if(driver.getTitle().equals("TestFlight - Apple")) {
				break;}}
		//switchToWindow("TestFlight - Apple");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Terms of Service']")).click();
		Thread.sleep(2000);
		driver.switchTo().window(homeWindowid);
		
	}}
	/*private void switchToWindow(String expTitle) throws InterruptedException {
		// TODO Auto-generated method stub
		Set<String> windowIds=driver.getWindowHandles();
		Iterator<String> it=windowIds.iterator();
		
		while(it.hasNext()) {
			String windowId=it.next();
			driver.switchTo().window(windowId);
			Thread.sleep(2000);
			if(driver.getTitle().equals(expTitle)) {
				break;
			}*/
		
		
		
		
		
		
		
	

