package com.mercury.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mercury.qa.base.TestBase;

public class TestUtil extends TestBase
{
	public static int PAGE_LOAD_TIMEOUT=30;
	public static int IMPLICIT_WAIT=20;
	private static XSSFWorkbook wb;
	private static Logger log = Logger.getLogger("TestUtil.class");

	public static Object[][] getTestData(String sheetName)
	{
		try
		{
			File src = new File("G:\\Mercury tours workspace\\MercuryTours\\src\\main\\java\\com\\mercury\\qa\\testdata\\TestData.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}catch(Exception e)
		{
			log.info("Unable to read test data file: "+sheetName);
			System.out.println(e.getMessage());
		}
		int rows = wb.getSheet(sheetName).getLastRowNum();
		Object[][] credentials = new Object[rows][2];
		for(int i=1;i<=rows;i++)
			for(int j=0;j<2;j++)
				credentials[i-1][j]=getData(sheetName,i, j);
		log.info("Test data fetched from testdata file successfully");
		return credentials;
	}

	private static String getData(String sheetName,int row,int column)
	{
		XSSFSheet sheet=wb.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		log.info("Trying to take screenshot");
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("G:\\Mercury tours workspace\\MercuryTours\\Screenshots\\"+System.currentTimeMillis()+".png");
	    FileUtils.copyFile(SrcFile, DestFile);
	    log.info("Screenshot has been taken successfully");
	}

}
