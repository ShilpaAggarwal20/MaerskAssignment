package com.ml.blaze.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	WebDriver driver;

	@BeforeTest
	public void setUpMethod() {

		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/googlechrome.exe");
		
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://blazedemo.com/");
	}
	
	/*
	@AfterTest
	public void tearDownMethod() {
		driver.close();

	}*/
}
