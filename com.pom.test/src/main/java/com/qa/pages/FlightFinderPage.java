package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qademo.base.TestBase;

public class FlightFinderPage extends TestBase{

	@FindBy(xpath="//img[@src='/images/masts/mast_flightfinder.gif']")
	WebElement HeaderImage;
	
	@FindBy(xpath="//input[@name='tripType']")
	WebElement TripType;
	
	@FindBy(xpath="//select[@name='passCount']")
	WebElement passengers;
	
	@FindBy(xpath="//select[@name='fromPort']")
	WebElement departingFrom;
	
	@FindBy(xpath="//select[@name='fromMonth']")
	WebElement departingOnMonth;
	
	@FindBy(xpath="//select[@name='fromDay']")
	WebElement departingOnDay;
	
	@FindBy(xpath="//select[@name='toPort']")
	WebElement arrivingInCity;
	
	@FindBy(xpath="//select[@name='toMonth']")
	WebElement returningOnMonth;
	
	@FindBy(xpath="//select[@name='toDay']")
	WebElement returningOnDay;
	
	@FindBy(xpath="//input[@name='servClass']")
	WebElement serviceClass;
	
	@FindBy(xpath="//input[@name='findFlights']")
	WebElement continueButton;
	
//	By HeaderImage = By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']");
//	By TripType = By.xpath("//input[@name='tripType']");
//	By passengers = By.xpath("//select[@name='passCount']");
//	By departingFrom = By.xpath("//select[@name='fromPort']");
//	By departingOnMonth = By.xpath("//select[@name='fromMonth']");
//	By departingOnDay = By.xpath("//select[@name='fromDay']");
//	By arrivingInCity = By.xpath("//select[@name='toPort']");
//	By returningOnMonth = By.xpath("//select[@name='toMonth']");
//	By returningOnDay = By.xpath("//select[@name='toDay']");
//	
//	By serviceClass = By.xpath("//input[@name='servClass']");
//	By continueButton = By.xpath("//input[@name='findFlights']");
	
	public FlightFinderPage() throws IOException {
	
	
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateFlightFinderPage()
	{
		return HeaderImage.isDisplayed();
	}
	
	public SelectFlightPage enterFlightDetails(String flightType, String passengersCount, String cityFrom, String DepartMonth, String departingDay, String arrivingCity, String returningMonth, String returningDay, String serviceClassType)
	{
		driver.findElements(By.xpath("//input[@name='tripType']")).get(Integer.parseInt(flightType));


		Select selectPassengers =new Select(passengers);
		selectPassengers.selectByValue(passengersCount);
		


		Select selectDepartCity=new Select(departingFrom);
		selectDepartCity.selectByValue(cityFrom);
		

		Select selectDepartMonth=new Select(departingOnMonth);
		selectDepartMonth.selectByValue(DepartMonth);


		Select selectDepartingDay=new Select(departingOnDay);
		selectDepartingDay.selectByValue(departingDay);
		
		Select select=new Select(arrivingInCity);
		select.selectByValue(arrivingCity);
		

		Select selectReturningMonth=new Select(returningOnMonth);
		selectReturningMonth.selectByValue(returningMonth);
		

		Select selectReturningDay=new Select(returningOnDay);
		selectReturningDay.selectByValue(returningDay);
		
	
		driver.findElements(By.xpath("//input[@name='servClass']")).get(Integer.parseInt(serviceClassType)).click();
		
		
		continueButton.click();
		
		return new SelectFlightPage();

	}
	
	
	
}
