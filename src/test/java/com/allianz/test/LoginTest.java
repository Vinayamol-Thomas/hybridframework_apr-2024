package com.allianz.test;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.alianz.base.AutomationWrapper;

public class LoginTest extends AutomationWrapper {
	
	@Test
	public void validLoginTest()
	{
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualHeader=driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		Assert.assertEquals(actualHeader, "Dashboard");
	}
}
