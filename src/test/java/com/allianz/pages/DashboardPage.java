package com.allianz.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.alianz.base.WebDriverKeywords;

public class DashboardPage extends WebDriverKeywords {
private  WebDriver driver;
private By dashboardHeaderLocator= By.xpath("//h6[text()='Dashboard']");
	
	public  DashboardPage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
	}
	public String  getDashboardHeader()
	{
		return getText(dashboardHeaderLocator);
	}
}
