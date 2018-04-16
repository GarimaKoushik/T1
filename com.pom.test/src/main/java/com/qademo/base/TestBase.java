package com.qademo.base;

import java.util.Properties;
import java.io.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.utils.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase() throws IOException
	{
		try {
		prop = new Properties();
		FileInputStream fis =new FileInputStream("D:\\Maven Projects\\com.pom.test\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(fis);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Softwares\\Automation\\2.Project Selenium\\3. Webdrivers\\Chrome Driver 2.36\\chromedriver.exe");
		
		driver=new ChromeDriver();
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		
		
		
	}
	
	
	

}
