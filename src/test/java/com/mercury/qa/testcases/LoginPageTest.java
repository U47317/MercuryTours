package com.mercury.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	private LoginPage loginPage;
	public LoginPageTest()
	{
		super();
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
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
