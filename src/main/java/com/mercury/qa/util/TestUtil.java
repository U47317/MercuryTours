package com.mercury.qa.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil 
{
	public static int PAGE_LOAD_TIMEOUT=30;
	public static int IMPLICIT_WAIT=20;
	private static XSSFWorkbook wb;
	private static XSSFSheet sheet;
	private static Logger log = Logger.getLogger("TestUtil.class");


	public static Object[][] getTestData(String sheetName)
	{
		
		
		
		try{
			File src = new File("G:\\Mercury tours workspace\\MercuryTours\\src\\main\\java\\com\\mercury\\qa\\testdata\\TestData.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			}catch(Exception e)
			{
				log.info("Unable to read test data file: "+sheetName);
				System.out.println(e.getMessage());
			}
		int rows = wb.getSheet(sheetName).getLastRowNum();
		System.out.println("Number of rows: "+rows);
		Object[][] credentials = new Object[rows][2];
		for(int i=1;i<=rows;i++)
			for(int j=0;j<2;j++)
				credentials[i-1][j]=getData(sheetName,i, j);
		log.info("Test data fetched from testdata file successfully");
		return credentials;
	}


	private static String getData(String sheetName,int row,int column)
	{
		sheet=wb.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
}
