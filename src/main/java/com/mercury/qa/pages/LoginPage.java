package com.mercury.qa.pages;

import com.mercury.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
}
