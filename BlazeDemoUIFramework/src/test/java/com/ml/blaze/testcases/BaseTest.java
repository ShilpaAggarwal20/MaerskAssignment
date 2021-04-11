package com.ml.blaze.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	WebDriver driver;

	@Parameters("browers")
	@BeforeTest
	public void setUpMethod(@Optional("chrome") String browser) {

		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		
		if(browser.equalsIgnoreCase("chrome"))
		driver = new ChromeDriver();
		
		if(browser.equalsIgnoreCase("gecko"))
			driver = new FirefoxDriver(); 
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.MILLISECONDS);
	}
	
	
	@AfterTest
	public void tearDownMethod() {
		driver.close();

	}
}
