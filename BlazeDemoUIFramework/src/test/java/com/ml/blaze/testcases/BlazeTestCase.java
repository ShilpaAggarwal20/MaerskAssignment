package com.ml.blaze.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ml.blaze.page.objects.BlazeBookingConfirmPage;
import com.ml.blaze.page.objects.BlazeChooseFlightPage;
import com.ml.blaze.page.objects.BlazeFlightPurchasePage;
import com.ml.blaze.page.objects.BlazeHomePage;
import com.ml.blaze.utilities.ExcelReader;

public class BlazeTestCase extends BaseTest {

	@Test
	public void VerifyConfirmationID() {
		
		HashMap<String,String> findFlightMap = new HashMap<String,String>();
		
		try {
			findFlightMap = ExcelReader.readDataFromExcel("FindFlight", 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BlazeHomePage homepg = new BlazeHomePage(driver);
		homepg.selectDepartureCity(findFlightMap.get("DepartureCity"));
		homepg.selectDestination(findFlightMap.get("DestinationCity"));
		homepg.submitFlightBtn();
		
		BlazeChooseFlightPage choosepg = new BlazeChooseFlightPage(driver);
		double minPrice=choosepg.findMinPrice();
		choosepg.chooseMinPriceFlight(minPrice);
	
		HashMap<String,String> purchaseDataMap = new HashMap<String,String>();
		
		try {
			purchaseDataMap = ExcelReader.readDataFromExcel("PurchaseFlight", 1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		BlazeFlightPurchasePage purchasepg =  new BlazeFlightPurchasePage(driver);
		purchasepg.fillPurchaseFlightFields(purchaseDataMap);
		
		BlazeBookingConfirmPage confirmpg = new BlazeBookingConfirmPage(driver);
	    Assert.assertEquals(confirmpg.getJsonConfirmationID(),confirmpg.getConfirmationID());
	}
	
}
