package com.mercury.qa.pages;

import com.mercury.qa.base.TestBase;

public class FlightFinderPage extends TestBase 
{
 public String validatePageTitle()
 {
	 return driver.getTitle();
 }
}
