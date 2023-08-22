package testscripts.regression;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BasePage;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class ValidteSearchHotelUsingDataProvider extends BasePage {
	
	@Test(dataProvider="dataset")
	public void validationShotelUsingDP(HashMap<String, String> hmap) {
		LoginPage lP=PageFactory.initElements(driver, LoginPage.class);
		lP.userNameTextBox(hmap.get("username"));
		lP.passwordTextBox(hmap.get("password"));
		lP.loginButton();
		Assert.assertEquals(lP.getTitleOfPage(),(hmap.get("expectedtitle1")));
		SearchHotelPage sHP=PageFactory.initElements(driver, SearchHotelPage.class);
		sHP.hotelsDropdown(hmap.get("hotelname"));
		sHP.adultsPerRoomDropdown(hmap.get("adultsperroom"));
		sHP.checkInDateTextBox(hmap.get("checkindate"));
		sHP.checkOutTextBox(hmap.get("checkoutdate"));
		sHP.locationDropdown(hmap.get("location"));
		sHP.noOfRoomsDropdown(hmap.get("noofrooms"));
		sHP.roomTypeDropdown(hmap.get("roomtype"));
		sHP.searchButton();
		Assert.assertEquals(sHP.getTitleOfPage(),(hmap.get("expectedtitle2")));
	}
	@DataProvider
	public Object[][] dataset() throws IOException{
		Object[][] data=new Object[1][1];
		data[0][0]=UtilKit.getTestCase("TC-01");
		return data;
		
	

}}
