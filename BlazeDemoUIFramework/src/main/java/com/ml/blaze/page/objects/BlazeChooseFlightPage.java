package com.ml.blaze.page.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeChooseFlightPage {

	WebDriver driver;
	
	public BlazeChooseFlightPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table/tbody/tr")
	List <WebElement> tableRows;
	
	@FindBy(xpath="//table/tbody/tr/td[6]")
	List <WebElement> flightPrices;
	
	@FindBy(xpath="//table/tbody/tr/td[1]/input[@class='btn btn-small']")
	List <WebElement> chooseFlightBtn;
	
	
	
	public double findMinPrice() {
		int noOfRows = tableRows.size();
		double minPrice=Integer.MAX_VALUE;
		for(int i =0 ; i <noOfRows ; i++) {
			double flightPrice= Double.valueOf(flightPrices.get(i).getText().replace("$", ""));
			if(minPrice>flightPrice)
				minPrice=flightPrice;
		}
		return minPrice;
	}
	
	public void chooseMinPriceFlight(double minPriceChoosen) {
		int noOfRows = tableRows.size();
		for(int i =0 ; i <noOfRows ; i++) {
			if(minPriceChoosen==Double.valueOf(flightPrices.get(i).getText().replace("$", "")))
				chooseFlightBtn.get(i).click();
		}	
	}
}
