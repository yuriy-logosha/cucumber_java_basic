Feature: As a user, I want to interact with the employee list, so it can be modified

	Background:
		Given I am on person list page
		
	Scenario: User adds a new person
		When Add a new person
			| name        | Test             |
			| surname     | Person           |
			| job         | Dream Job        |
			| dob         | 03/22/1980       |
			| language    | English, Spanish |
			| genderId    | male             |
			| statusValue | contractor       |
		Then a new user shall be added to the list
		And the new user has the information I entered
		And no other persons were changed
		
	Scenario: User adding a new person
		When Adding a person
			| name        | Test             |
			| surname     | Person           |
			| job         | Dream Job        |
			| dob         | 03/22/1980       |
			| language    | English, Spanish |
			| genderId    | male             |
			| statusValue | contractor       |
		Then a new user shall be added to the list
		And the new user has the information I entered
		And no other persons were changed
	
	Scenario Outline: User edits a person
		When Edit a person
			| personId    | <personId>       |
			| name        | Test             |
			| surname     | Person           |
			| job         | Dream Job        |
			| language    | English, Spanish |
		Then the information of person with personid "<personId>" shall change
		And no other persons were changed	
		Examples:
			| personId |
			|  person0 |
		
	Scenario Outline: User edits a person
		When Editing a person
			| personId    | <personId>       |
			| name        | Test             |
			| surname     | Person           |
			| job         | Dream Job        |
			| language    | English, Spanish |
		Then the information of person with personid "<personId>" shall change
		And no other persons were changed
		Examples:
			| personId |
			|  person0 |
	
	Scenario Outline: User deletes a person
		When Remove a person "<personId>"
		Then the person with personid "<personId>" shall not be on the list
		And no other persons were changed
		Examples:
			| personId |
			|  person0 |
	
	Scenario Outline: User deletes a person
		When Removing a person "<personId>"
		Then the person with personid "<personId>" shall not be on the list
		And no other persons were changed
		Examples:
			| personId |
			|  person0 |
	
	Scenario: User resets the list to original state after deleting the person
		Given a list of initial persons
		When Remove a person "person1"
		And reset original list
		Then list shall contain only initial persons
	
	Scenario: User resets the list after adding a new person
		Given a list of initial persons
		When Add a new person
			| name        | Test             |
			| surname     | Person           |
			| job         | Dream Job        |
			| dob         | 03/22/1980       |
			| language    | English, Spanish |
			| genderId    | male             |
			| statusValue | contractor       |
		And reset original list
		And list shall contain only initial persons
	
	Scenario: Check that clear button works correctly on adding a user
		Given I am on new person form
		And fill the form
			| name        | Test             |
			| surname     | Person           |
			| job         | Dream Job        |
			| dob         | 03/22/1980       |
			| language    | English, Spanish |
			| genderId    | male             |
			| statusValue | contractor       |
		And click clear all fields
		Then known language shall be "English"
		And employee status shall be "Employee"
		And non-default fields shall be empty