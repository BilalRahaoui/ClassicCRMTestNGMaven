package com.classiccrm.testdata;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {

	public static Object[][] validLoginData() throws Exception {
		String validLoginPath = new File("src/main/resources/DataProvider/valid_login_data.xlsx").getAbsolutePath();
		File file = new File(validLoginPath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("ValidLogin");
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
	public static Object[][] loginTestData() throws Exception {
		String loginDataPath = new File("src/main/resources/DataProvider/login_data_test.xlsx").getAbsolutePath();
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

	public static Object[][] contactData() throws Exception {
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
