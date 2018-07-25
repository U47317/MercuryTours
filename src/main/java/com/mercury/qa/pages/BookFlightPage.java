package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
}
