package automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import graphql.Assert;

public class TestNGDemo1 {
	@AfterMethod
	public void tearDown() {
		System.out.println("25");
	}

	@BeforeMethod
	public void startBrowser() {
		System.out.println("50");

	}

	@Test(priority = 1)
	public void loginTesting() {
		System.out.println("10");
		System.out.println("20");
		Assert.assertTrue(true);
	}

	@Test(priority = 3)
	public void registrationTest() {
		System.out.println("30");
		System.out.println("40");
	}

	@Test(priority = 2, dependsOnMethods = "loginTesting")
	public void changePassword() {
		System.out.println("60");
		System.out.println("70");
		System.out.println("80");
		System.out.println("90");

	}

}
