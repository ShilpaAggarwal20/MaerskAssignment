package com.ml.weather.actions;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherConnector {
	
	private String getCityWeather= "api.openweathermap.org/data/2.5/weather";
	
	public Response getWeather(RequestSpecification reqSpec, String city) {
		Response resp=RestAssured.given().spec(reqSpec).queryParam("q", city).request("GET",getCityWeather);
		return resp;
	}

}
