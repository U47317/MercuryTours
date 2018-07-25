package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.TestBase;

public class SelectFlightPage extends TestBase
{

	protected static String departFlightName;
	protected static String returnFlightName;
	protected static String departFlightFare;
	protected static String returnFlightFare;
	
	@FindBy(xpath="//form[@action='mercurypurchase.php']//following-sibling::table//td[@class='frame_action_xrows']//input[@checked and @name='outFlight']//parent::td//parent::tr//following-sibling::tr//td[@class='frame_action_xrows']//input[@type='radio' and @name='outFlight' and contains(@value,'Blue')]")
	WebElement departFlightRadioButton;
	
	@FindBy(xpath="//form[@action='mercurypurchase.php']//following-sibling::table//td[@class='frame_action_xrows']//input[@checked and @name='outFlight']//parent::td//parent::tr//following-sibling::tr//td[@class='frame_action_xrows']//input[@type='radio' and @name='outFlight' and contains(@value,'Blue')]//parent::td//following-sibling::td//font//b")
	WebElement departFlightNameText;
	
	@FindBy(xpath="//form[@action='mercurypurchase.php']//following-sibling::table//td[@class='frame_action_xrows']//input[@checked and @name='outFlight']//parent::td//parent::tr//following-sibling::tr//td[@class='frame_action_xrows']//input[@type='radio' and @name='outFlight' and contains(@value,'Blue')]//parent::td//following-sibling::td//parent::tr//following-sibling::tr//td[@class='data_verb_xcols']//b[contains(text(),'271')]")
	WebElement departFlightFareText;
	
	@FindBy(xpath="//form[@action='mercurypurchase.php']//following-sibling::table//td[@class='frame_action_xrows']//input[@checked and @name='inFlight']//parent::td//parent::tr//following-sibling::tr//td[@class='frame_action_xrows']//input[@type='radio' and @name='inFlight' and contains(@value,'Blue')]")
	WebElement returnFlightRadioButton;
	
	@FindBy(xpath="//form[@action='mercurypurchase.php']//following-sibling::table//td[@class='frame_action_xrows']//input[@checked and @name='inFlight']//parent::td//parent::tr//following-sibling::tr//td[@class='frame_action_xrows']//input[@type='radio' and @name='inFlight' and contains(@value,'Blue')]//parent::td//following-sibling::td//font//b")
	WebElement returnFlightNameText;
	
	@FindBy(xpath="//form[@action='mercurypurchase.php']//following-sibling::table//td[@class='frame_action_xrows']//input[@checked and @name='inFlight']//parent::td//parent::tr//following-sibling::tr//td[@class='frame_action_xrows']//input[@type='radio' and @name='inFlight' and contains(@value,'Blue')]//parent::*//parent::tr//following-sibling::tr//td[@class='data_verb_xcols']//b[contains(text(),'273')]")
	WebElement returnFlightFareText;
	
	@FindBy(xpath="//input[@name='reserveFlights']")
	WebElement continueButton;
	
	public SelectFlightPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public void validateFlightSelection()
	{
		departFlightRadioButton.click();
		departFlightName=departFlightNameText.getText();
		returnFlightRadioButton.click();
		returnFlightName=returnFlightNameText.getText();
		departFlightFare=departFlightFareText.getText().trim().replace("Price: $", "").trim();
		returnFlightFare=returnFlightFareText.getText().trim().replace("Price: $", "").trim();
		continueButton.click();
	}
	
}
