package com.PostMessageValidationSD;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PostMessageValidation {

	
	
	@Given("post the data to create user")
	public void post_the_data_to_create_user() {
		
	}
	
	@Then("validate status code is {int}")
	public void validate_status_code_is(Integer int1) {
	   		
	}
	
		
		
	
}
