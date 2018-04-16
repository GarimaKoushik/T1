package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qademo.base.TestBase;

public class TestUtil extends TestBase{
	
	static FileInputStream fis;
	static HSSFWorkbook wb;
	static String strFilePath = "D:\\Maven Projects\\com.pom.test\\src\\main\\java\\com\\qademo\\testdata\\BookFlight3.xls";
	
	public TestUtil() throws IOException {

	}

	public void switchToFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
	}
	
	public static Object[][] getTestData(String sheetName)
	{
		try {
			
				fis =new FileInputStream(strFilePath);
				wb = new HSSFWorkbook(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	
		catch(IOException e)
		{
			e.printStackTrace();
		}
			HSSFSheet Sheet =wb.getSheet(sheetName);
			
			Object[][] data = new Object[Sheet.getLastRowNum()][Sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<Sheet.getLastRowNum();i++)
			{
				for(int j=0;j<Sheet.getRow(0).getLastCellNum();j++)
				{
					data[i][j]=Sheet.getRow(i+1).getCell(j).toString();
				}
			}
		
	
		return data;
	}

}
