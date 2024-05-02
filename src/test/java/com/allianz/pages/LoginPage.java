package com.allianz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.alianz.base.WebDriverKeywords;

public class LoginPage extends WebDriverKeywords {
	private By usernameLocator=By.name("username");
	private By passwordLocator=By.name("password");
	private By loginLocator=By.xpath("//button[@type='submit']");
	private By errorLocator= By.xpath("//p[text()='Invalid credentials']");
	private  WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
public  void enterUsername(String username)
	{
	super.setInputText(usernameLocator, username);
	}
public  void enterPassword(String password)
{
	setInputText(passwordLocator, password);
}
public  void clickOnLogin()
{
	clickElement(loginLocator);
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