package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
	//WebElement userNameTextBox=driver.findElement(By.xpath(""));
	@FindBy(xpath="//input[@name='username']")
	WebElement userNameTextBox;
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordTextBox;
	@FindBy(xpath="//input[@name='login']")
	WebElement loginButton;
	@FindBy(xpath="//a[text()='New User Register Here']")
	WebElement registrationButton;
	public void userNameTextBox(String username) {
		userNameTextBox.sendKeys(username);
	}
	public void passwordTextBox(String password) {
		passwordTextBox.sendKeys(password);
	}
	public void loginButton() {
		loginButton.click();
	}
	public void registrationButton() {
		registrationButton.click();
	}

}
