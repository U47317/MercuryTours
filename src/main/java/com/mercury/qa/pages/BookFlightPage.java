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
	
	@FindBy(xpath="//td[@class='data_left']//parent::tr//following-sibling::tr//font//font//b//parent::font//parent::font//parent::font//parent::td//following-sibling::td[@class='data_center_mono']//font")
	WebElement destinationToSourceFlightType;
	
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
		Assert.assertEquals(destinationToSourceText.getText(), FlightFinderPage.destinationLocation+" to "+FlightFinderPage.sourceLocation);
		Assert.assertEquals(destinationToSourceFlightName.getText(), FlightFinderPage.airline+" 631");
		Assert.assertEquals(destinationToSourceFlightType.getText(), FlightFinderPage.serviceClass);
	}
	
}
