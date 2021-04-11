package com.ml.blaze.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BlazeHomePage {
WebDriver driver;
	
	@FindBy(xpath ="//select[@name='fromPort']")
	WebElement departureCityDropdown;
	
	@FindBy(xpath ="//select[@name='toPort']")
	WebElement destinationDropdown;
	
	@FindBy(xpath ="//input[@class='btn btn-primary']")
	WebElement findFlightBtn;
	
	
	public BlazeHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectDepartureCity(String departCity) {
		Select departSelect = new Select(departureCityDropdown);
			departSelect.selectByValue(departCity);
	}
	
	public void selectDestination(String destCity) {
		Select destSelect = new Select(destinationDropdown);
		destSelect.selectByValue(destCity);
	}
	
	public void submitFlightBtn() {
		findFlightBtn.submit();
	}
}
