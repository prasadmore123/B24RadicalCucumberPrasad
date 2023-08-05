package com.ApplicationUP;


import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApllicationUPStepDef {

	Response response;
	
	@Given("hit the URI")
	public void hit_the_uri() {
		response = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
		System.out.println("Got the response");
	}

	@Then("validate the response {string} of application")
	public void validate_the_response_of_application(String statusCode) {
		response.then().log().all();
		String actualStatusCode = ""+response.getStatusCode()+"";
		//int expectedStatusCode = 200;
		Assert.assertEquals(statusCode, actualStatusCode);
	}

	
}
