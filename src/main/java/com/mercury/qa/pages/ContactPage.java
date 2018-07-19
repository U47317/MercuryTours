package com.mercury.qa.pages;

import com.mercury.qa.base.TestBase;

public class ContactPage extends TestBase {

	public String validateTitle()
	{
		return driver.getTitle();
	}
}
