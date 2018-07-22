package com.mercury.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.FlightFinderPage;
import com.mercury.qa.pages.LoginPage;
import com.mercury.qa.pages.SelectFlightPage;

public class SelectFlightTest extends TestBase {

	private SelectFlightPage selectFlightPage;
	private LoginPage loginPage;
	private FlightFinderPage flightFinderPage;
	private static Logger log = Logger.getLogger(SelectFlightTest.class);
	SelectFlightTest()
	{
		loadConfigurationFile();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		selectFlightPage=new SelectFlightPage();
		loginPage=new LoginPage();
		flightFinderPage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		selectFlightPage=flightFinderPage.findFlights();
		}
	
	@Test(priority=21)
	public void validateDepartReturnFlightSelection()
	{
		log.info("******Validate Depart Return Flight Selection******");
		selectFlightPage.validateFlightSelection();
		log.info("******END******");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
