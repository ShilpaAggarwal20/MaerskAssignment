package com.ml.blaze.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

	public static HashMap<String,String> readDataFromExcel(String sheetName, int rowNum) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/BlazePurchaseFlightData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Row header = sheet.getRow(0);


		HashMap<String, String> map = new HashMap<String, String>();

		for(int j=0 ; j<header.getLastCellNum() ; j++)
		{
			DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
			map.put(header.getCell(j).getStringCellValue(),formatter.formatCellValue(sheet.getRow(rowNum).getCell(j)));

		}

		return map;

	}
}
