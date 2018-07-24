package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.TestBase;

public class SelectFlightPage extends TestBase
{

	protected static String departFlightName;
	protected static String returnFlightName;
	
	@FindBy(xpath="//form[@action='mercurypurchase.php']//following-sibling::table//td[@class='frame_action_xrows']//input[@checked and @name='outFlight']//parent::td//parent::tr//following-sibling::tr//td[@class='frame_action_xrows']//input[@type='radio' and @name='outFlight' and contains(@value,'Blue')]")
	WebElement departFlightRadioButton;
	
	@FindBy(xpath="//form[@action='mercurypurchase.php']//following-sibling::table//td[@class='frame_action_xrows']//input[@checked and @name='outFlight']//parent::td//parent::tr//following-sibling::tr//td[@class='frame_action_xrows']//input[@type='radio' and @name='outFlight' and contains(@value,'Blue')]//parent::td//following-sibling::td//font//b")
	WebElement departFlightNameText;
	
	@FindBy(xpath="//form[@action='mercurypurchase.php']//following-sibling::table//td[@class='frame_action_xrows']//input[@checked and @name='inFlight']//parent::td//parent::tr//following-sibling::tr//td[@class='frame_action_xrows']//input[@type='radio' and @name='inFlight' and contains(@value,'Blue')]")
	WebElement returnFlightRadioButton;
	
	@FindBy(xpath="//form[@action='mercurypurchase.php']//following-sibling::table//td[@class='frame_action_xrows']//input[@checked and @name='inFlight']//parent::td//parent::tr//following-sibling::tr//td[@class='frame_action_xrows']//input[@type='radio' and @name='inFlight' and contains(@value,'Blue')]//parent::td//following-sibling::td//font//b")
	WebElement returnFlightNameText;
	
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
		continueButton.click();
	}
	
}
