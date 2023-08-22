package pages;

import base.BasePage;

public class Page extends BasePage{
public String getTitleOfPage() {
	String title= driver.getTitle();
	return title;
	
}
}
