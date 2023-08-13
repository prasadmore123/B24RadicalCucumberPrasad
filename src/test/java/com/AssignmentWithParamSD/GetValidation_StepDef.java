package com.AssignmentWithParamSD;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.collections4.functors.ForClosure;
import org.junit.Assert;

import freemarker.core.ReturnInstruction.Return;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetValidation_StepDef {

	Response response; 
	String bookName = null;
	@Given("if title of book is \"Speaking JavaScript\"")
	public void if_title_of_book_is_Speaking_JavaScript(String bookName) {
		response = RestAssured.get("https://demoqa.com/BookStore/v1/Books");
		System.out.println("got the response");
			
	}
	
	
	@Then("validate that its author is \"Axel Rauschmayer\"")
	public void validate_that_its_author_is_Axel_Rauschmayer(String author) {
		
		// String bookName = "Speaking JavaScript";
		String dataString = response.getBody().asString();
		System.out.println("Akk Data ===="+dataString);
		List<String> allTitle	= response.getBody().jsonPath().getList("books[].title");
		int size = allTitle.size();
		for(int i=0; i<size; i++){
			String actualTitleString = response.getBody().jsonPath().getString("books[i].title");
			if (actualTitleString==bookName) {
				int pagesInt = response.getBody().jsonPath().getInt("books[i].pages");
				String pagesString =""+pagesInt+"";
				Assert.assertEquals(pagesString, author);
				break;	
			}
			else {
				continue;
			}
			
		}	
		
	}
}
