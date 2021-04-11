package com.ml.blaze.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeBookingConfirmPage {

WebDriver driver;
	
	public BlazeBookingConfirmPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table/tbody/tr[1]/td[2]")
	WebElement confirmationID;
	
	@FindBy(xpath="//table/tbody/tr[2]/td[2]")
	WebElement confirmationStatus;
	
}
