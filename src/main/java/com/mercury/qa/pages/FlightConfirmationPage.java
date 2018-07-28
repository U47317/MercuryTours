package com.mercury.qa.pages;

import com.mercury.qa.base.TestBase;

public class FlightConfirmationPage extends TestBase{

	public String validateTitle()
	{
		return driver.getTitle();
	}
}
