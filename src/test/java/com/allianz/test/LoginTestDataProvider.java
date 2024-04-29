package com.allianz.test;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alianz.base.AutomationWrapper;
import com.allianz.utils.DataUtils;

public class LoginTestDataProvider extends AutomationWrapper {
	
	@Test(dataProvider="commonDataProvider" ,dataProviderClass=DataUtils.class)
	public void ValidLoginTest(String username, String password, String expectedHeader)
	{
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		String actualHeader=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		Assert.assertEquals(actualHeader, expectedHeader);
	}
	
	@Test(dataProvider="commonDataProvider" ,dataProviderClass=DataUtils.class)
	public void invalidLoginTest(String username, String password, String expected)
	{
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualerror=driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
		Assert.assertEquals(actualerror, expected);
	}
}
