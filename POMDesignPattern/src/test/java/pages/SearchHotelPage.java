package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage extends Page {
	@FindBy(xpath="//select[@name='location']")
	WebElement locationDropdown;
	@FindBy(xpath="//select[@name='hotels']")
	WebElement hotelsDropdown;
	@FindBy(xpath="//select[@name='room_type']")
	WebElement roomTypeDropdown;
	@FindBy(xpath="//select[@name='room_nos']")
	WebElement noOfRoomsDropdown;
	@FindBy(xpath="//input[@name='datepick_in']")
	WebElement checkInDateTextBox;
	@FindBy(xpath="//input[@name='datepick_out']")
	WebElement checkOutDateTextBox;
	@FindBy(xpath="//select[@name='adult_room']")
	WebElement adultsPerRoomDropdown;
	@FindBy(xpath="//input[@name='Submit']")
	WebElement searchButton;
	public void locationDropdown(String text) {
		Select se=new Select(locationDropdown);
		se.selectByVisibleText(text);
	}
	public void hotelsDropdown(String text) {
		Select se=new Select(hotelsDropdown);
		se.selectByVisibleText(text);
	}
	public void roomTypeDropdown(String text) {
		Select se=new Select(roomTypeDropdown);
		se.selectByVisibleText(text);
	}
	public void noOfRoomsDropdown(String text) {
		Select se=new Select(noOfRoomsDropdown);
		se.selectByVisibleText(text);
	}
	public void checkInDateTextBox(String text) {
		checkInDateTextBox.clear();
		checkInDateTextBox.sendKeys(text);
	}
	public void checkOutTextBox(String text) {
		checkOutDateTextBox.clear();
		checkOutDateTextBox.sendKeys(text);
	}
	public void adultsPerRoomDropdown(String text) {
		adultsPerRoomDropdown.clear();
		adultsPerRoomDropdown.sendKeys(text);
		
	}
	public void searchButton() {
		searchButton.click();
	}
	

}
