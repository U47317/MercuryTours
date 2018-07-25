package com.mercury.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.BookFlightPage;
import com.mercury.qa.pages.FlightFinderPage;
import com.mercury.qa.pages.LoginPage;
import com.mercury.qa.pages.SelectFlightPage;

public class BookFlightTest extends TestBase{

	private SelectFlightPage selectFlightPage;
	private LoginPage loginPage;
	private FlightFinderPage flightFinderPage;
	private BookFlightPage bookFlightPage;
	private static Logger log = Logger.getLogger(BookFlightTest.class);
	
	public BookFlightTest()
	{
		log.info("BookFlightTest configuration file");
		loadConfigurationFile();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage=new LoginPage();
		selectFlightPage=new SelectFlightPage();
		bookFlightPage=new BookFlightPage();
		flightFinderPage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		selectFlightPage=flightFinderPage.findFlights();
		selectFlightPage.validateFlightSelection();
		
	}
	@Test(priority=22)
	public void validateSummaryTest()
	{
		log.info("******Validate Summary in Book Flight Test******");
		bookFlightPage.validateSummary();
		log.info("******END******");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("Browser closed successfully");
	}
}
