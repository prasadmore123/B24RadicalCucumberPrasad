
@Regression
Feature: validate POST request

  @smoke
	Scenario: 1. Validate you are able to create data in the system 
	Given post the data to create user
	Then validate status code is "201"
	Then validate id created for user with non null value
	Then validate id created for user with non zero value
	
	@smoke @API
	Scenario: 2.Validate you are able to create user from File
  Given post the data to create user from file
  Then validate status code is "201"
  Then validate id created for user with non null value 
  Then validate id created for user with non zero value
  
  Scenario: 3.Validate you are able to create user from update File with name field
  Given post the data to create user from file with updated name
  Then validate status code is "201"
  Then validate id created for user with non null value 
  Then validate id created for user with non zero value
  
  #Scenario: 4.Validate you are able to create user and delete the user
    #Given post the data to create user from file with updated fields
    #Then validate status code is "201"
    #Then validate id created for user with non null value 
    #Then validate id created for user with non zero value
    #When delete the user from system 
    #Then validate user deleted from system