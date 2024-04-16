package com.allianz.test;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alianz.base.AutomationWrapper;
import com.allianz.utils.DataUtils;

public class LoginTestDataProvider extends AutomationWrapper {
	
	@Test
	public void validLoginTest()
	{
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualHeader=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		Assert.assertEquals(actualHeader, "Dashboard");
	}
	
	@Test(dataProvider="invalidLoginData" ,dataProviderClass=DataUtils.class)
	public void invalidLoginTest(String username, String password, String expected)
	{
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualerror=driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
		Assert.assertEquals(actualerror, expected);
	}
}
