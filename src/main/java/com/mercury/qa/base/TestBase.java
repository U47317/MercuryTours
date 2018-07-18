package com.mercury.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mercury.qa.util.TestUtil;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase()
	{
		//for loading configuration file
		try 
		{
			prop=new Properties();
			FileInputStream ip = new FileInputStream("G:\\Mercury tours workspace\\MercuryTours\\src\\main\\java\\com\\mercury\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "G:\\Mercury tours workspace\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.getProperty("webdriver.gecko.driver", "G:\\Mercury tours workspace\\firefoxdriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	

}
