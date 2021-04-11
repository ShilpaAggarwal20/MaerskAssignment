package com.ml.blaze.page.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlazeChooseFlight {

	WebDriver driver;
	
	public BlazeChooseFlight(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//table/tbody/tr")
	List <WebElement> tableRows;
	
	@FindBy(xpath="//table/tbody/tr/td[6]")
	List <WebElement> flightPrice;
	
	@FindBy(xpath="//table/tbody/tr/td[1]/input[@class='btn btn-small']")
	List <WebElement> chooseFlightBtn;
	
	int noOfRows = tableRows.size();
	
	public int findMinPrice() {
		int minPrice=Integer.MAX_VALUE;
		for(int i =0 ; i <noOfRows ; i++) {
			
			if(minPrice>Integer.valueOf(flightPrice.get(i).getText()))
				minPrice=Integer.valueOf(flightPrice.get(i).getText());
		}
		return minPrice;
	}
	
	public void chooseMinPriceFlight(int minPriceChoosen) {
		
		for(int i =0 ; i <noOfRows ; i++) {
			if(minPriceChoosen==Integer.valueOf(flightPrice.get(i).getText()))
				chooseFlightBtn.get(i).submit();
		}	
	}
}
