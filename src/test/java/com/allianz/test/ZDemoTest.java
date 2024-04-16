package com.allianz.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ZDemoTest {
	@DataProvider
	public String[][] validData()
	{
		String[][] data=new String[3][2];
		data[0][0]="Saul";
		data[0][1]="Saul123";
		data[1][0]="Peter";
		data[1][1]="Peter123";
		data[2][0]="Kim";
		data[2][1]="Kim123";
		return data;
		
	}
	@Test(dataProvider="validData")
	public void validTest(String userName, String password)
	{
		System.out.println("Valid Test"+userName+password);
	}

}
