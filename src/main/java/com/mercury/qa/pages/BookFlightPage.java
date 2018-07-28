package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.mercury.qa.base.TestBase;

public class BookFlightPage extends TestBase
{
	
	
	
	@FindBy(xpath="//td[@class='frame_header_info']//font[contains(text(),'to')]")
	WebElement sourceToDestinationText;
	
	@FindBy(xpath="//td[@class='data_left']//font[contains(text(),'to')]")
	WebElement destinationToSourceText;
	
	@FindBy(xpath="//td[@class='data_center_mono']//preceding-sibling::td//font//a//preceding-sibling::b")
	WebElement sourceToDestinationFlightName;
	
	@FindBy(xpath="//td[@class='data_left']//parent::tr//following-sibling::tr//font//font//b")
	WebElement destinationToSourceFlightName;
	
	@FindBy(xpath="//td[@class='data_center_mono']//preceding-sibling::td//font//a//preceding-sibling::b//parent::font//parent::td//following-sibling::td[@class='data_center_mono']//font")
	WebElement sourceToDestinationFlightType;
	
	@FindBy(xpath="//td[@class='data_center_mono']//preceding-sibling::td//font//a//preceding-sibling::b//parent::font//parent::td//following-sibling::td[@class='data_center_mono']//following-sibling::td[@class='data_center']//font")
	WebElement sourceToDestinationFlightFareText;
	
	@FindBy(xpath="//td[@class='data_left']//parent::tr//following-sibling::tr//font//font//b//parent::font//parent::font//parent::font//parent::td//following-sibling::td[@class='data_center_mono']//font")
	WebElement destinationToSourceFlightType;
	
	@FindBy(xpath="//td[@class='data_left']//parent::tr//following-sibling::tr//font//font//b//parent::font//parent::font//parent::font//parent::td//following-sibling::td[@class='data_center_mono']//following-sibling::td[@class='data_center']//font")
	WebElement destinationToSourceFlightFareText;
	
	@FindBy(xpath="//td[@class='data_left']/font[text()='Passengers:']//parent::td//following-sibling::td//font")
	WebElement numberOfPassengersText;
	
	@FindBy(xpath="//tr//font[contains(text(),'Taxes:')]//parent::*//following-sibling::td//font")
	WebElement taxesText;
	
	@FindBy(xpath="//tr//font[contains(text(),'Total Price')]//parent::*//following-sibling::td//font")
	WebElement totalPriceText;
	
	@FindBy(xpath="//input[@name='passFirst0']")
	WebElement passenger1FirstNameField;
	
	@FindBy(xpath="//input[@name='passLast0']")
	WebElement passenger1LastNameField;
	
	@FindBy(xpath="//select[@name='pass.0.meal']")
	WebElement passenger1MealTypeDropDown;
	
	@FindBy(xpath="//input[@name='passFirst1']")
	WebElement passenger2FirstNameField;
	
	@FindBy(xpath="//input[@name='passLast1']")
	WebElement passenger2LastNameField;
	
	@FindBy(xpath="//select[@name='pass.1.meal']")
	WebElement passenger2MealTypeDropDown;
	
	@FindBy(xpath="//select[@name='creditCard']")
	WebElement creditCardTypeDropDown;
	
	@FindBy(xpath="//input[@name='creditnumber']")
	WebElement creditCardNumberField;
	
	@FindBy(xpath="//select[@name='cc_exp_dt_mn']")
	WebElement expirationMonthDropDown;
	
	@FindBy(xpath="//select[@name='cc_exp_dt_yr']")
	WebElement expirationYearDropDown;
	
	@FindBy(xpath="//input[@name='cc_frst_name']")
	WebElement creditCardFirstNameField;
	
	@FindBy(xpath="//input[@name='cc_mid_name']")
	WebElement creditCardMiddleNameField;
	
	@FindBy(xpath="//input[@name='cc_last_name']")
	WebElement creditCardLastNameField;
	
	@FindBy(xpath="//input[@name='billAddress1']")
	WebElement billingAddressFirstField;
	
	@FindBy(xpath="//input[@name='billCity']")
	WebElement billingAddressCityField;
	
	@FindBy(xpath="//input[@name='billState']")
	WebElement billingAddressStateField;
	
	@FindBy(xpath="//input[@name='billZip']")
	WebElement billingAddressPostalCodeField;
	
	@FindBy(xpath="//select[@name='billCountry']")
	WebElement billingAddressCountryDropDown;
	
	@FindBy(xpath="//font[contains(text(),'Same as Billing Address')]//preceding-sibling::input")
	WebElement sameAsBillingAddressCheckBox;
	
	@FindBy(xpath="//input[@name='buyFlights']")
	WebElement securePurchaseButton;
	
	public BookFlightPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public void validateSummary()
	{
		
		Assert.assertEquals(sourceToDestinationText.getText(),FlightFinderPage.sourceLocation+" to "+FlightFinderPage.destinationLocation );
		Assert.assertEquals(sourceToDestinationFlightName.getText(), FlightFinderPage.airline+" 361");
		Assert.assertEquals(sourceToDestinationFlightType.getText(), FlightFinderPage.serviceClass);
		Assert.assertEquals(sourceToDestinationFlightFareText.getText(), SelectFlightPage.departFlightFare);
		Assert.assertEquals(destinationToSourceText.getText(), FlightFinderPage.destinationLocation+" to "+FlightFinderPage.sourceLocation);
		Assert.assertEquals(destinationToSourceFlightName.getText(), FlightFinderPage.airline+" 631");
		Assert.assertEquals(destinationToSourceFlightType.getText(), FlightFinderPage.serviceClass);
		Assert.assertEquals(destinationToSourceFlightFareText.getText(), SelectFlightPage.returnFlightFare);
		Assert.assertEquals(numberOfPassengersText.getText(), FlightFinderPage.passengerDropDownValue);
		Assert.assertEquals(totalPriceText.getText().trim().replace("$", ""), calculateTotalPrice());
		
	}
	
	public String calculateTotalPrice()
	{
		int tax= Integer.parseInt(taxesText.getText().trim().replace("$", "").trim());
		int departingPrice=Integer.parseInt(sourceToDestinationFlightFareText.getText());
		int returningPrice=Integer.parseInt(destinationToSourceFlightFareText.getText());
		return String.valueOf(tax+(departingPrice+returningPrice)*Integer.parseInt(FlightFinderPage.passengerDropDownValue));
	}
	
	public FlightConfirmationPage validateFlightBooking()
	{
		Select sel;
		passenger1FirstNameField.sendKeys("Antony");
		passenger1LastNameField.sendKeys("James");
		sel=new Select(passenger1MealTypeDropDown);
		sel.selectByVisibleText("Kosher");
		passenger2FirstNameField.sendKeys("Susan");
		passenger2LastNameField.sendKeys("Alex");
		sel=new Select(passenger2MealTypeDropDown);
		sel.selectByVisibleText("Diabetic");
		sel=new Select(creditCardTypeDropDown);
		sel.selectByVisibleText("Visa");
		creditCardNumberField.sendKeys("6634565435654");
		sel=new Select(expirationMonthDropDown);
		sel.selectByIndex(2);
		sel=new Select(expirationYearDropDown);
		sel.selectByIndex(5);
		creditCardFirstNameField.sendKeys("Mark");
		creditCardMiddleNameField.sendKeys("Antony");
		creditCardLastNameField.sendKeys("James");
		billingAddressFirstField.clear();
		billingAddressFirstField.sendKeys("Sunview Block");
		billingAddressCityField.clear();
		billingAddressCityField.sendKeys("DownTown");
		billingAddressStateField.clear();
		billingAddressStateField.sendKeys("LA");
		billingAddressPostalCodeField.clear();
		billingAddressPostalCodeField.sendKeys("576883");
		sel=new Select(billingAddressCountryDropDown);
		sel.selectByVisibleText("CANADA");
		sameAsBillingAddressCheckBox.click();
		securePurchaseButton.click();
		return new FlightConfirmationPage();
	}
	
}
