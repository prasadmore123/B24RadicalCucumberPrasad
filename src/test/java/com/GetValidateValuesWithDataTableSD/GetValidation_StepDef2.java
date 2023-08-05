package com.GetValidateValuesWithDataTableSD;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetValidation_StepDef2 {

	Response response; 
	
	@Given("hit the URI")
	public void hit_the_uri() {
		response = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
		System.out.println("got the response");
		
	}
	
	@Then("validate value for below data")
	public void validate_value_for_below_data(DataTable allData) {
		
		List<List<String>> allDataInList = allData.asLists();
		String singleValueString = allDataInList.get(0).get(0);
	    System.out.println("========="+singleValueString);
	    
	    String secondValueString = allDataInList.get(0).get(1);
	    System.out.println("========="+secondValueString);
	    
	      
		for (int i=0; i<allDataInList.size(); i++) {
				String actualTitleString = response.getBody().jsonPath().getString(allDataInList.get(i).get(0));
				Assert.assertTrue(actualTitleString.equals(allDataInList.get(i).get(1)));
			
		}
	    	
	}
		
}
