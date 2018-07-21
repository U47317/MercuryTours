package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(xpath="//a[contains(text(),'SIGN-ON')]")
	WebElement signOnLink;
	
	@FindBy(xpath="//a[contains(text(),'REGISTER')]")
	WebElement registerLink;
	
	@FindBy(xpath="//a[contains(text(),'SUPPORT')]")
	WebElement supportLink;
	
	@FindBy(xpath="//a[contains(text(),'CONTACT')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement homeLink;
	
	@FindBy(xpath="//a[contains(text(),'Flights')]")
	WebElement flightsLink;
	
	@FindBy(xpath="//a[contains(text(),'Hotels')]")
	WebElement hotelsLink;
	
	@FindBy(xpath="//a[contains(text(),'Car Rentals')]")
	WebElement carRentalsLink;
	
	@FindBy(xpath="//a[contains(text(),'Cruises')]")
	WebElement cruisesLink;
	
	@FindBy(xpath="//a[contains(text(),'Destinations')]")
	WebElement destinationsLink;
	
	@FindBy(xpath="//a[contains(text(),'Vacations')]")
	WebElement vacationsLink;
	
	@FindBy(xpath="//img[@alt='Mercury Tours']")
	WebElement logo;
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement userNameField;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordField;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginButton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateSignOnLinkPresent()
	{
		return signOnLink.isDisplayed();
	}
	
	public boolean validateRegisterLinkPresent()
	{
		return registerLink.isDisplayed();
	}
	
	public boolean validateSupportLinkPresent()
	{
		return supportLink.isDisplayed();
	}
	
	public boolean validateContactLinkPresent()
	{
		return contactLink.isDisplayed();
	}
	
	public boolean validateHomeLinkPresent()
	{
		return homeLink.isDisplayed();
	}
	
	public boolean validateFlightsLinkPresent()
	{
		return flightsLink.isDisplayed();
	}
	
	public boolean validateHotelsLinkPresent()
	{
		return hotelsLink.isDisplayed();
	}
	
	public boolean validateCarRentalsLinkPresent()
	{
		return carRentalsLink.isDisplayed();
	}
	
	public boolean validateCruisesLinkPresent()
	{
		return cruisesLink.isDisplayed();
	}
	
	public boolean validateDestinationsLinkPresent()
	{
		return destinationsLink.isDisplayed();
	}
	
	public boolean validateVacationsLinkPresent()
	{
		return vacationsLink.isDisplayed();
	}
	
	public boolean validateLogoPresent()
	{
		return logo.isDisplayed();
	}
	
	public SignOnPage validateClickOnSignOnLink()
	{
		signOnLink.click();
		return new SignOnPage();
	}
	
	public RegisterPage validateClickOnRegisterLink()
	{
		registerLink.click();
		return new RegisterPage();
	}
	
	public SupportPage validateClickOnSupportLink()
	{
		supportLink.click();
		return new SupportPage();
	}
	
	public ContactPage validateClickOnContactLink()
	{
		contactLink.click();
		return new ContactPage();
	}
	
	public FlightFinderPage validateLogin(String username,String password)
	{
		userNameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		return new FlightFinderPage();
		
		
	}
	
	//space for left side links 
	
}
