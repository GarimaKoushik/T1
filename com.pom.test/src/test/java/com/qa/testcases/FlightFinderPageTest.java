package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.FlightFinderPage;
import com.qa.pages.LoginPage;
import com.qa.pages.SelectFlightPage;
import com.qa.utils.TestUtil;
import com.qademo.base.TestBase;

public class FlightFinderPageTest extends TestBase {
	

	FlightFinderPage objFlightFinderPage;
	LoginPage objLoginPage = new LoginPage();
	SelectFlightPage objSelectFlightPage;
	TestUtil objTestUtil;
	
	
	public FlightFinderPageTest() throws IOException {
		super();

	}
	
	
	
	@BeforeMethod
	public void initialize() throws IOException
	{
		initialization();
		objFlightFinderPage=objLoginPage.login();
		objTestUtil=new TestUtil();

	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=TestUtil.getTestData("FlightDetail");
		return data;
	}
	
	@Test (priority=1, dataProvider="getData")
	public void flightFinderPageTest(String flightType, String passengers, String departFrom, String departingMonth, String departingDay, String arrivingIn, String arrivingMonth, String arrivingDay, String serviceType )
	{
		boolean flag=objFlightFinderPage.validateFlightFinderPage();
		Assert.assertTrue(flag);

		//objSelectFlightPage=objFlightFinderPage.enterFlightDetails(0, "1", "London", "7", "10", "Frankfurt", "7", "15", 0);
		objSelectFlightPage=objFlightFinderPage.enterFlightDetails(flightType, passengers, departFrom, departingMonth, departingDay, arrivingIn, arrivingMonth, arrivingDay, serviceType);
		

	}
	
	
}
