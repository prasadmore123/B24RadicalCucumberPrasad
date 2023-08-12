package com.UpdateMessageValidationSD2;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.*;

public class PostMessageValidation {

	
	Response response = null;
	
	@Given("update the data to create user")
	public void update_the_data_to_create_user() {
		
		response = RestAssured
				.given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.body("{\r\n"
						+ "    \"name\": \"user222\",\r\n"
						+ "    \"job\": \"QA leader\",\r\n"
						+ "    \"mob\": \"122\",\r\n"
						+ "    \"dept\": \"QA-Automation\",\r\n"
						+ "    \"location\": \"Pune\"\r\n"
						+ "}\r\n"
						+ "")
				.put("https://reqres.in/api/users");
	}
	
	@Then("validate status code is {string}")
	public void validate_status_code_is(String statuscode) {
	   		Assert.assertEquals(statuscode,""+ response.getStatusCode()+"");
	}
	
	@Then("validate id created for user with non null value")
	public void validate_id_created_for_user_with_non_null_value() {
		String id = response.body().jsonPath().getString("id");
		Assert.assertTrue(!id.equals(null));
	}
	
	@Then("validate id created for user with non zero value")
	public void validate_id_created_for_user_with_non_zero_value() {
		int id = response.body().jsonPath().getInt("id");
	    Assert.assertTrue(id > 0 );
	}
	
	@Given("Update the data to create user from file")
	public void Update_the_data_to_create_user_from_file() {
		File file = new File("src/test/java/com/UpdateMessageValidationSD/CreateUser.json");
		response = RestAssured
				.given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.body(file)
				.put("https://reqres.in/api/users");
	}
	
	@Given("Update the data to create user from file with updated name")
	public void Update_the_data_to_create_user_from_file_with_updated_name() throws IOException {
		String dataString = new String(Files.readAllBytes(Paths.get("src/test/java/com/UpdateMessageValidationSD/CreateUser.json")));
		JSONObject jsonObject = new JSONObject(dataString);
		double randomNum = Math.random();
		jsonObject.put("name", "userNewName"+randomNum);
		String finalDataString = jsonObject.toString();
		response = RestAssured
				.given()
				.relaxedHTTPSValidation()
				.accept(ContentType.JSON)
				.body(finalDataString)
				.put("https://reqres.in/api/users");
		response.then().log().all();
	}
					
}
