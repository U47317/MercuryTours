package com.mercury.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.FlightFinderPage;
import com.mercury.qa.pages.LoginPage;
import com.mercury.qa.pages.SelectFlightPage;

public class FlightFinderTest extends TestBase {
	
	private FlightFinderPage flightFinderPage;
	private LoginPage loginPage;
	private SelectFlightPage selectFlightPage;
	private static Logger log = Logger.getLogger(FlightFinderTest.class);
	
	public FlightFinderTest()
	{
		log.info("FlightFinderTest configuration file");
		loadConfigurationFile();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage=new LoginPage();
		flightFinderPage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=20)
	public void validateFlightFinderTest()
	{
		log.info("******Validate Flight Finder Test******");
		selectFlightPage=flightFinderPage.findFlights();
		Assert.assertEquals(selectFlightPage.validateTitle(),"Select a Flight: Mercury Tours");
		log.info("******END******");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("Browser closed successfully");
	}

}
