package testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import base.BasePage;
import pages.LoginPage;

public class ValidateLogin extends BasePage {
	@Test
	public void validateLoginTest() {
		LoginPage lP=PageFactory.initElements(driver, LoginPage.class);
		lP.userNameTextBox("Saikirankondeti9");
		lP.passwordTextBox("Sai@123");
		lP.loginButton();
		
	}

}
