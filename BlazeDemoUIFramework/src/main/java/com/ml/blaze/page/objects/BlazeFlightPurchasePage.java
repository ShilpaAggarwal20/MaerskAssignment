package com.ml.blaze.page.objects;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BlazeFlightPurchasePage {

WebDriver driver;
	
	public BlazeFlightPurchasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='inputName']")
	WebElement nameTextFld;
	
	@FindBy(id="address")
	WebElement addressTextFld;
	
	@FindBy(id="city")
	WebElement cityTextFld;
	
	@FindBy(id="state")
	WebElement stateTextFld;
	
	@FindBy(id="zipCode")
	WebElement zipCodeTextFld;
	
	@FindBy(id="cardType")
	WebElement cardTypeDropdown;
	
	@FindBy(id="creditCardNumber")
	WebElement creditCardNumberTextFld;
	
	@FindBy(id="creditCardMonth")
	WebElement creditCardMonthTextFld;
	
	@FindBy(id="creditCardYear")
	WebElement creditCardYearTextFld;
	
	@FindBy(id="nameOnCard")
	WebElement nameOnCardTextFld;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement purchaseFlightBtn;
	
	public void fillPurchaseFlightFields(HashMap<String,String> purchaseDataMap) {
		
		nameTextFld.sendKeys(purchaseDataMap.get("Name"));
		addressTextFld.sendKeys(purchaseDataMap.get("Address"));
		cityTextFld.sendKeys(purchaseDataMap.get("City"));
		stateTextFld.sendKeys(purchaseDataMap.get("State"));
		zipCodeTextFld.sendKeys(purchaseDataMap.get("ZipCode"));
		creditCardNumberTextFld.sendKeys(purchaseDataMap.get("Credit Card Number"));
		creditCardMonthTextFld.sendKeys(purchaseDataMap.get("Month"));
		creditCardYearTextFld.sendKeys(purchaseDataMap.get("Year"));
		nameOnCardTextFld.sendKeys(purchaseDataMap.get("Name on Card"));
		
		Select cardDropDown =  new Select(cardTypeDropdown);
		cardDropDown.selectByValue(purchaseDataMap.get("Card Type"));
		
		purchaseFlightBtn.submit();
	}
	
}
