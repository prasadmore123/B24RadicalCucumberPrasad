Feature: validate POST request

	Scenario: 1. Validate you are able to create data in the system 
	Given post the data to create user
	Then validate status code is 201
	Then validate id created for user with non null value
	Then validate id created for user with non zero value