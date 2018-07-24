package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mercury.qa.base.TestBase;

public class FlightFinderPage extends TestBase 
{
 
	protected static String passengerDropDownValue;
	protected static String sourceLocation;
	protected static String departingMonth;
	protected static String departingDay;
	protected static String destinationLocation;
	protected static String returningMonth;
	protected static String returningDay;
	protected static String serviceClass;
	protected static String airline;
 
 
 	@FindBy(xpath="//input[@type='radio' and @name='tripType' and @value='oneway']")
	WebElement roundTripRadioButton;

	@FindBy(xpath="//select[@name='passCount']")
	WebElement passengersDropDown;

	@FindBy(xpath="//select[@name='fromPort']")
	WebElement departingFromDropDown;

	@FindBy(xpath="//select[@name='fromMonth']")
	WebElement onMonthDropDown;

	@FindBy(xpath="//select[@name='toDay']")
	WebElement onDayDropDown;

	@FindBy(xpath="//select[@name='toPort']")
	WebElement arrivingInDropDown;

	@FindBy(xpath="//select[@name='toMonth']")
	WebElement returningMonthDropDown;

	@FindBy(xpath="//select[@name='toDay']")
	WebElement returningDayDropDown;

	@FindBy(xpath="//input[@type='radio' and @value='Business']")
	WebElement serviceClassRadioButton;

	@FindBy(xpath="//select[@name='airline']")
	WebElement airlineDropDown;
	
	@FindBy(xpath="//input[@name='findFlights']")
	WebElement continueButton;
	
	FlightFinderPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle()
	{
		return driver.getTitle();
	}

	public SelectFlightPage findFlights()
	{
		Select sel;
		roundTripRadioButton.click();
		sel = new Select(passengersDropDown);
		sel.selectByIndex(1);
		passengerDropDownValue=sel.getFirstSelectedOption().getText();
		sel= new Select(departingFromDropDown);
		sel.selectByVisibleText("New York");
		sourceLocation=sel.getFirstSelectedOption().getText();
		sel=new Select(onMonthDropDown);
		sel.selectByValue("8");
		departingMonth=sel.getFirstSelectedOption().getText();
		sel=new Select(onDayDropDown);
		sel.selectByVisibleText("10");
		departingDay=sel.getFirstSelectedOption().getText();
		sel=new Select(arrivingInDropDown);
		sel.selectByVisibleText("Paris");
		destinationLocation=sel.getFirstSelectedOption().getText();
		sel=new Select(returningMonthDropDown);
		sel.selectByVisibleText("August");
		returningMonth=sel.getFirstSelectedOption().getText();
		sel=new Select(returningDayDropDown);
		sel.selectByVisibleText("20");
		returningDay=sel.getFirstSelectedOption().getText();
		serviceClassRadioButton.click();
		serviceClass=serviceClassRadioButton.getAttribute("value");
		sel=new Select(airlineDropDown);
		sel.selectByVisibleText("Blue Skies Airlines");
		airline=sel.getFirstSelectedOption().getText();
		continueButton.click();
		return new SelectFlightPage();
	}

}
