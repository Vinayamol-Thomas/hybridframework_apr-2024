package com.allianz.test;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alianz.base.AutomationWrapper;
import com.allianz.pages.LoginPage;
import com.allianz.utils.DataUtils;

public class LoginTestDataProvider extends AutomationWrapper {
	
	@Test(dataProvider="commonDataProvider" ,dataProviderClass=DataUtils.class)
	public void ValidLoginTest(String username, String password, String expectedHeader)
	{
		
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLogin(driver);
		
		String actualHeader=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	@Test(dataProvider="commonDataProvider" ,dataProviderClass=DataUtils.class)
	public void invalidLoginTest(String username, String password, String expected)
	{
		
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLogin(driver);
		String actualerror=driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
		Assert.assertEquals(actualerror, expected);
	}
}
