package com.vTiger.GenericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\com\\vtiger\\CommonData\\CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public Object readExcelData(String sheetName,int row,int column) throws Throwable{
		FileInputStream file=new FileInputStream("");
		Workbook wb=WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public Object[][] getAllExcelData(String sheetName) throws Throwable{
		FileInputStream file=new FileInputStream("");
		Workbook wb=WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		int lastCell=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	public void writeDataToExcel(String sheetName,int rowNum,int column,String data) throws Throwable {
		FileInputStream file=new FileInputStream("");
		Workbook wb=WorkbookFactory.create(file);
		Sheet sheet=wb.getSheet(sheetName);
		Row row=sheet.getRow(rowNum);
		Cell cell = row.getCell(column);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("");
		wb.write(fos);
		
	}

}
