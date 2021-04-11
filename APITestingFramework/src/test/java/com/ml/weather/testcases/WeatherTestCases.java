package com.ml.weather.testcases;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ml.weather.actions.WeatherConnector;
import com.ml.weather.utilities.ExcelReader;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherTestCases {
	WeatherConnector weatherConnector= new WeatherConnector();

	@Test
	void getWeatherForOneLocation() throws IOException {
		
		HashMap<String,String> cityMap = new HashMap<String,String>();
		//fetching city
		cityMap=ExcelReader.readCityData("City", 1);
		//building request specification for get weather API
		RequestSpecification resSpec= new RequestSpecBuilder().addHeader("Content-Type", "application/json").addQueryParam("appid", "b7cd927a16c4f947cb0686cab649ea35").build();
		
		//calling get method to fetch the response
		Response response = weatherConnector.getWeather(resSpec, cityMap.get("City"));
		
		String jsonPath = "WeatherResponseSchema.json";
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(jsonPath));

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(JsonPath.with(response.asString()).get("name"),cityMap.get("City"));
		Assert.assertNotNull(JsonPath.with(response.asString()).get("main.temp"));
		Assert.assertNotNull(JsonPath.with(response.asString()).get("weather.description"));
		Assert.assertNotNull(JsonPath.with(response.asString()).get("sys.country"));
	}
	
	@Test
	void verifyResponseForIncorrectCity() throws IOException {
		
		HashMap<String,String> cityMap = new HashMap<String,String>();
		cityMap=ExcelReader.readCityData("City", 2);
		
		RequestSpecification resSpec= new RequestSpecBuilder().addHeader("Content-Type", "application/json").addQueryParam("appid", "b7cd927a16c4f947cb0686cab649ea35").build();
		
		Response response = weatherConnector.getWeather(resSpec, cityMap.get("City"));
	
		Assert.assertEquals(response.getStatusCode(),404);
		Assert.assertEquals(JsonPath.with(response.asString()).get("message"),"city not found");
	}
	
	@Test
	void VerfiyResponseForIncorrectAuth() throws IOException {
		
		HashMap<String,String> cityMap = new HashMap<String,String>();
		cityMap=ExcelReader.readCityData("City", 1);
		
		RequestSpecification resSpec= new RequestSpecBuilder().addHeader("Content-Type", "application/json").addQueryParam("appid", "b7cd927a16c447cb0686cab649ea35").build();
		
		Response response = weatherConnector.getWeather(resSpec, cityMap.get("City"));
	
		Assert.assertEquals(response.getStatusCode(),401);
		
	}
}
