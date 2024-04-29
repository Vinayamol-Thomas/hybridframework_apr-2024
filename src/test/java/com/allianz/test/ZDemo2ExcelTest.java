package com.allianz.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZDemo2ExcelTest {
	public static void main(String[] args) throws IOException
	{
	FileInputStream file =new FileInputStream("src/test/resources/test_data/hrm_data.xlsx");
	XSSFWorkbook book = new XSSFWorkbook(file);
	XSSFSheet sheet= book.getSheet("InvalidLoginTest");
	int rowount=sheet.getPhysicalNumberOfRows();
	int columnCount=sheet.getRow(0).getPhysicalNumberOfCells();
	Object[][] data=new Object[rowount-1][columnCount];
	DataFormatter format= new DataFormatter();
	for(int i=1;i<rowount;i++)
	{
	for(int j=0;j<columnCount;j++)	
	{
	
		String value=format.formatCellValue(sheet.getRow(i).getCell(j));
		
		System.out.println(value);
		data[i-1][j]=value;
	
	}
	}
	System.out.println(data);
	book.close();
	file.close();
}
}
