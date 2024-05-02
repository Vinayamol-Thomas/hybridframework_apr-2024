package com.allianz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage2 {
	private By usernameLocator=By.name("username");
	private By passwordLocator=By.name("password");
	private By loginLocator=By.xpath("//button[@type='submit']");
	private By errorLocator= By.xpath("//p[text()='Invalid credentials']");
	private  WebDriver driver;
	
	public LoginPage2(WebDriver driver)
	{
		this.driver=driver;
	}
	
public  void enterUsername(String username)
	{
	driver.findElement(usernameLocator).sendKeys(username);
	}
public  void enterPassword(String password)
{
	driver.findElement(passwordLocator).sendKeys(password);
}
public  void clickOnLogin()
{
	driver.findElement(loginLocator).click();
}
public String getInvalidErrorMessage()
{
return driver.findElement(errorLocator).getText();	
}
public String getUsernamePlaceholder()
{
	return driver.findElement(usernameLocator).getAttribute("placeholder");
	}
public String getPasswordPlaceholder()
{
	return driver.findElement(passwordLocator).getAttribute("placeholder");
	}
}