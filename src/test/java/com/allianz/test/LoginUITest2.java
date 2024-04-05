package com.allianz.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginUITest2 {
	@Test(priority=1)
	public void titleTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		String pageTitle= driver.getTitle();
		System.out.println("Page title of launched application is : "+pageTitle);
		Assert.assertEquals(pageTitle, "OrangeHRM", pageTitle);
	}
	@Test(invocationCount = 3, priority=2)
	public void applicationDescriptionTest()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		String actulaVersion=driver.findElement(By.xpath("//p[contains(@class,'orangehrm-copyright')][1]")).getText();
		Assert.assertEquals(actulaVersion, "OrangeHRM OS 5.6.1");
	}

}
