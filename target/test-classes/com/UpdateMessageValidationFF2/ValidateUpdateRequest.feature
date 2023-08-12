Feature: validate UPDATE request

	Scenario: 1. Validate you are able to create data in the system 
	Given update the data to create user
	Then validate status code is "201"
	Then validate id created for user with non null value
	Then validate id created for user with non zero value
	
	#Scenario: 2.Validate you are able to create user from File
  #Given update the data to create user from file
  #Then validate status code is "201"
  #Then validate id created for user with non null value 
  #Then validate id created for user with non zero value
  
  #Scenario: 3.Validate you are able to create user from update File with name field
  #Given update the data to create user from file with updated name
  #Then validate status code is "201"
  #Then validate id created for user with non null value 
  #Then validate id created for user with non zero value