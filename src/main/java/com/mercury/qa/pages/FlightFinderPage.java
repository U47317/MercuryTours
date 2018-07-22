package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mercury.qa.base.TestBase;

public class FlightFinderPage extends TestBase 
{
 private Select sel;
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
		roundTripRadioButton.click();
		sel = new Select(passengersDropDown);
		sel.selectByIndex(1);
		sel= new Select(departingFromDropDown);
		sel.selectByVisibleText("New York");
		sel=new Select(onMonthDropDown);
		sel.selectByValue("8");
		sel=new Select(onDayDropDown);
		sel.selectByVisibleText("10");
		sel=new Select(arrivingInDropDown);
		sel.selectByVisibleText("Paris");
		sel=new Select(returningMonthDropDown);
		sel.selectByVisibleText("August");
		sel=new Select(returningDayDropDown);
		sel.selectByVisibleText("20");
		serviceClassRadioButton.click();
		sel=new Select(airlineDropDown);
		continueButton.click();
		return new SelectFlightPage();
	}

}
