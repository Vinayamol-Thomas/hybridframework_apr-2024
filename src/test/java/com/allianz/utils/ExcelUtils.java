package com.allianz.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// converting sheeting into 2 dimensional array excluding header
public class ExcelUtils {
	public static Object[][] getSheetIntoTwoDimensionalArray(String path, String sheetName) throws IOException
	{
		FileInputStream file =new FileInputStream(path);
		XSSFWorkbook book = new XSSFWorkbook(file);
		XSSFSheet sheet= book.getSheet(sheetName);
		int rowount=sheet.getPhysicalNumberOfRows();
		int columnCount=sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][] data=new Object[rowount-1][columnCount];
		DataFormatter format= new DataFormatter();
		for(int i=1;i<rowount;i++)
		{
		for(int j=0;j<columnCount;j++)	
		{
		
			String value=format.formatCellValue(sheet.getRow(i).getCell(j));
			
			
			data[i-1][j]=value;
		
		}
		}
	
		book.close();
		file.close();
		return data;
		
	}

}
