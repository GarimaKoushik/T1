package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;


import com.qademo.base.TestBase;

public class LoginPage extends TestBase{

	public LoginPage() throws IOException {
		
		
	}


	By loginPageHeaderImage=By.xpath("//img[@src='/images/masts/mast_signon.gif']");
												///images/masts/mast_signon.gif

	By username =By.name("userName");
	
	By password =By.name("password");
	
	By btnSubmit = By.xpath("//table//*[@name='login']");
	
	//By flightFinderHeaderImage =By.xpath("//img[@src='/images/masts/mast_signon.gif']");



	
public boolean  vaidateLoginTitle()
{

	boolean imagePresent=driver.findElement(loginPageHeaderImage).isDisplayed();
	return imagePresent;
}
public FlightFinderPage login() throws IOException
{
	driver.findElement(username).sendKeys("thalesh");
	driver.findElement(password).sendKeys("thalesh");
	driver.findElement(loginPageHeaderImage).click();
	driver.findElement(btnSubmit).click();
	return new FlightFinderPage();
}
}