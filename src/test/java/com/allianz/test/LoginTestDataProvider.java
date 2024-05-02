package com.allianz.test;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alianz.base.AutomationWrapper;
import com.allianz.pages.DashboardPage;
import com.allianz.pages.LoginPage;
import com.allianz.utils.DataUtils;

public class LoginTestDataProvider extends AutomationWrapper {
	
	@Test(dataProvider="commonDataProvider" ,dataProviderClass=DataUtils.class)
	public void ValidLoginTest(String username, String password, String expectedHeader)
	{
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername( username);
		loginpage.enterPassword( password);
		loginpage.clickOnLogin();
		DashboardPage dashboardPage= new DashboardPage(driver);
		String actualHeader=dashboardPage.getDashboardHeader();
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	@Test(dataProvider="commonDataProvider" ,dataProviderClass=DataUtils.class)
	public void invalidLoginTest(String username, String password, String expected)
	{
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername( username);
		loginpage.enterPassword( password);
		loginpage.clickOnLogin();
		String actualerror=loginpage.getInvalidErrorMessage();
		Assert.assertEquals(actualerror, expected);
	}
}
