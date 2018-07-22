package com.mercury.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.ContactPage;
import com.mercury.qa.pages.FlightFinderPage;
import com.mercury.qa.pages.LoginPage;
import com.mercury.qa.pages.RegisterPage;
import com.mercury.qa.pages.SignOnPage;
import com.mercury.qa.pages.SupportPage;
import com.mercury.qa.util.TestUtil;

public class LoginPageTest extends TestBase
{
	private LoginPage loginPage;
	private FlightFinderPage flightFinderPage;
	private SignOnPage signOnPage;
	private RegisterPage registerPage;
	private SupportPage supportPage;
	private ContactPage contactPage;
	Logger log = Logger.getLogger(LoginPage.class);
	
	public LoginPageTest()
	{
		log.info("LoginpageTest configuration file");
		loadConfigurationFile();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void validateTitleTest()
	{
		log.info("******Validate login page title*****");
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");
		log.info("******END******");
		
	}
	
	@Test(priority=2)
	public void validateSignInLinkPresentTest()
	{
		log.info("******Validate signin link present******");
		Assert.assertEquals(loginPage.validateSignOnLinkPresent(), true);
		log.info("******END******");
	}
	
	@Test(priority=3)
	public void validateRegisterLinkPresentTest()
	{
		log.info("******Validate Register link present******");
		Assert.assertEquals(loginPage.validateRegisterLinkPresent(), true);
		log.info("******END******");
	}
	
	@Test(priority=4)
	public void validateSupportLinkPresentTest()
	{
		log.info("******Validate support link present******");
		Assert.assertEquals(loginPage.validateSupportLinkPresent(), true);
		log.info("******END******");
	}
	
	@Test(priority=5)
	public void validateContactLinkPresentTest()
	{
		log.info("******Validate contact link present******");
		Assert.assertEquals(loginPage.validateContactLinkPresent(), true);
		log.info("******END******");
	}
	
	@Test(priority=6)
	public void validateHomeLinkPresentTest()
	{
		log.info("******Validate home link present******");
		Assert.assertEquals(loginPage.validateHomeLinkPresent(), true);
		log.info("******END******");
	}
	
	@Test(priority=7)
	public void validateFlightsLinkPresentTest()
	{
		log.info("******Validate Flights link present******");
		Assert.assertEquals(loginPage.validateFlightsLinkPresent(), true);
		log.info("******END******");
	}
	
	@Test(priority=8)
	public void validateHotelsLinkPresentTest()
	{
		log.info("******Validate hotels link present******");
		Assert.assertEquals(loginPage.validateHotelsLinkPresent(), true);
		log.info("******END******");
	}
	
	@Test(priority=9)
	public void validateCarRentalsLinkPresentTest()
	{
		log.info("******Validate Car rentals link present******");
		Assert.assertEquals(loginPage.validateCarRentalsLinkPresent(), true);
		log.info("******END******");
	}
	
	@Test(priority=10)
	public void validateCruisesLinkPresentTest()
	{
		log.info("******Validate cruises link present******");
		Assert.assertEquals(loginPage.validateCruisesLinkPresent(), true);
		log.info("******END******");
	}
	
	@Test(priority=11)
	public void validateDestinationsLinkPresentTest()
	{
		log.info("******Validate destinations link present******");
		Assert.assertEquals(loginPage.validateDestinationsLinkPresent(), true);
		log.info("******END******");
	}
	
	@Test(priority=12)
	public void validateVacationsLinkPresentTest()
	{
		log.info("******Validate vacations link present******");
		Assert.assertEquals(loginPage.validateVacationsLinkPresent(), true);
		log.info("******END******");
	}
	
	@Test(priority=13)
	public void validateLogoPresentTest()
	{
		log.info("******Validate Logo present******");
		Assert.assertEquals(loginPage.validateLogoPresent(), true);
		log.info("******END******");
	}
	
	@Test(priority=14)
	public void validateClickOnSignInLinkTest()
	{
		log.info("******Validate click on signin link******");
		signOnPage=loginPage.validateClickOnSignOnLink();
		Assert.assertEquals(signOnPage.validateTitle(), "Sign-on: Mercury Tours");
		log.info("******END******");
	}
	
	@Test(priority=15)
	public void validateClickOnRegisterLinkTest()
	{
		log.info("******Validate click on register link******");
		registerPage=loginPage.validateClickOnRegisterLink();
		Assert.assertEquals(registerPage.validateTitle(), "Register: Mercury Tours");
		log.info("******END******");
	}
	
	@Test(priority=16)
	public void validateClickOnSupportLinkTest()
	{
		log.info("******Validate click on support link******");
		supportPage=loginPage.validateClickOnSupportLink();
		Assert.assertEquals(supportPage.validateTitle(), "Support: Mercury Tours");
		log.info("******END******");
	}
	
	@Test(priority=17)
	public void validateClickOnContactLinkTest()
	{
		log.info("******Validate click on contacts link******");
		contactPage=loginPage.validateClickOnContactLink();
		Assert.assertEquals(contactPage.validateTitle(), "Contact: Mercury Tours");
		log.info("******END******");
	}
	
	//Add left side links test cases in future
	
	@Test(priority=18,dataProvider="invalidtestdata")
	public void validateInvalidLoginTest(String USERNAME,String PASSWORD)
	{
		log.info("******Validate invalid Login******");
		log.info("Trying to Sign in with username: "+USERNAME+" and password: "+PASSWORD);
		flightFinderPage=loginPage.validateLogin(USERNAME, PASSWORD);
		Assert.assertEquals(flightFinderPage.validatePageTitle(), "Sign-on: Mercury Tours");
		log.info("******END******");
	}
	
	@DataProvider(name="invalidtestdata")
	private Object[][] fetchInvalidTestData()
	{
		return TestUtil.getTestData("InvalidLoginCredentials");
	}
	
	@Test(priority=19,dataProvider="validtestdata")
	public void validateValidLoginTest(String USERNAME,String PASSWORD)
	{
		log.info("******Validate valid Login******");
		log.info("Trying to Sign in with username: "+USERNAME+" and password: "+PASSWORD);
		flightFinderPage=loginPage.validateLogin(USERNAME, PASSWORD);
		Assert.assertEquals(flightFinderPage.validatePageTitle(), "Find a Flight: Mercury Tours:");
		log.info("******END******");
	}
	
	@DataProvider(name="validtestdata")
	private Object[][] fetchValidTestData()
	{
		return TestUtil.getTestData("ValidLoginCredentials");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		log.info("Browser closed successfully");
	}
	

}
