package com.classiccrm.testdata;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {

	//Read data for add new contact test from src/main/resources/DataProvider/invalid_login_data_test
	public static Object[][] loginTestData() throws Exception {
		//get absolute path for invalid_login_data_test.xlsx
		String loginDataPath = new File("src/main/resources/DataProvider/invalid_login_data_test.xlsx").getAbsolutePath();
		File file = new File(loginDataPath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("login_data");
		int rows = sheet.getLastRowNum()+1;
		int columns = sheet.getRow(0).getLastCellNum();
		Object data[][] = new Object[rows][columns];
		for(int i=0 ; i<rows ; i++) {
			for (int j = 0 ; j<columns ; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;	
	}
	//Read data for add new contact test from src/main/resources/DataProvider/contact_data_test.xlsx
	public static Object[][] contactData() throws Exception {
		//get absolute path for login_data_test.xlsx
		String contactDataPath = new File("src/main/resources/DataProvider/contact_data_test.xlsx").getAbsolutePath();
		File file = new File(contactDataPath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("contact_data");
		int rows = sheet.getLastRowNum()+1;
		int columns = sheet.getRow(0).getLastCellNum();
		Object data[][] = new Object[rows][columns];
		for(int i=0 ; i<rows ; i++) {
			for (int j = 0 ; j<columns ; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return data;	
	}
}
