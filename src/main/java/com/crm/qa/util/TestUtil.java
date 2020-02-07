package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;


import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	//Time values
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=20;
	static String path=System.getProperty("user.dir");
	public static String TESTDATA_SHEET_PATH = path+"\\"+"\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	//method to switch to Frame
	
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	
	//Take screenshot
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException {
		System.getProperty("user.dir");

			FileInputStream	file = new FileInputStream(TESTDATA_SHEET_PATH);
			//get the workbook
			Workbook book =  WorkbookFactory.create(file);
			//get the desired sheet
			sheet = book.getSheet(sheetName);
			//store the data in Object Array
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			//iterate through rows and columns
			//rows
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			//columns
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
}
