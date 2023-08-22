package testscripts.regression;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BasePage;
import pages.LoginPage;
import pages.SearchHotelPage;

public class ValidateSearchHotel extends BasePage {
	@Test
	public void validateSearchHotelTest() {
		LoginPage lP=PageFactory.initElements(driver, LoginPage.class);
		lP.userNameTextBox("");
		lP.passwordTextBox("");
		lP.loginButton();
		Assert.assertEquals(lP.getTitleOfPage(),"");
		SearchHotelPage sHP=PageFactory.initElements(driver, SearchHotelPage.class);
		sHP.hotelsDropdown("");
		sHP.adultsPerRoomDropdown("");
		sHP.checkInDateTextBox("");
		sHP.checkOutTextBox("");
		sHP.locationDropdown("");
		sHP.noOfRoomsDropdown("");
		sHP.roomTypeDropdown("");
		sHP.searchButton();
		Assert.assertEquals(sHP.getTitleOfPage(),"");
	}
	
	

}
