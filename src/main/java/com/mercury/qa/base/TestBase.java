package com.mercury.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



import com.mercury.qa.util.TestUtil;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	
	Logger log = Logger.getLogger(TestBase.class);
	
	public TestBase()
	{
		
	}
	
	public void loadConfigurationFile()
	{
		//for loading configuration file
				try 
				{
					prop=new Properties();
					FileInputStream ip = new FileInputStream("G:\\Mercury tours workspace\\MercuryTours\\src\\main\\java\\com\\mercury\\qa\\config\\config.properties");
					log.info("Trying to Load Configuration file.....");
					prop.load(ip);
					log.info("Configuration file loaded successfully....");
				} catch (Exception e) 
				{
					log.info("Failed to load configuration file");
					e.printStackTrace();
				}
				
	}
	
	public void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			log.info("Launching chrome browser");
			System.setProperty("webdriver.chrome.driver", "G:\\Mercury tours workspace\\chromedriver\\chromedriver.exe");
			driver=new ChromeDriver();
			log.info("Chrome launched successfully");
		}
		else if(browserName.equals("firefox"))
		{
			log.info("Launching firefox browser");
			System.getProperty("webdriver.gecko.driver", "G:\\Mercury tours workspace\\firefoxdriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Chrome launched successfully");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		log.info("URL launched successfully");
	}
	
	

}
