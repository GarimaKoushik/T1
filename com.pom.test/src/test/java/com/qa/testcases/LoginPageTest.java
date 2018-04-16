package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.FlightFinderPage;
import com.qa.pages.LoginPage;
import com.qademo.base.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	FlightFinderPage flightFinderPage;
	
	
	public LoginPageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public  void initialize() throws IOException
	{
		initialization();
		loginPage=new LoginPage();
				
	}
	
	
  @Test(priority=1)
  public void loginPageTitleTest() {
	  
	  boolean imagePresent =loginPage.vaidateLoginTitle();
	  Assert.assertTrue(imagePresent);
	  
  }
  @Test(priority=2)
  public void loginTest() throws IOException
  {
	  flightFinderPage=loginPage.login();

  }
  
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
  }
}
