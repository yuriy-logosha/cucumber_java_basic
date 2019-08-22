Feature: Tests for number enter page
	As a test engineer I want to be able to enter a number to receive its' square root
	
	Background:
		Given I am on the number entering page
	
	@IncorrectNumber
	Scenario Outline: Incorrect number is entered
		When I enter input: "<input>"
		And click submit
		Then I should see error: "<message>"
		Examples:
		| input | message                      |
		|  25   | Number is too small          |
		|  150  | Number is too big            |
		|       | You haven't entered anything |
		|  sad  | Please enter a number        |
	
	@CorrectNumber
	Scenario Outline: Enter number without remainder
		When I enter input: "<input>"
		And click submit
		Then I should receive an alert
		And the alert should say: "<message>"
		Examples:
		| input | message                     |
		|  64   | Square root of 64 is 8.00   |
		|  81   | Square root of 81 is 9.00   |
		|  100  | Square root of 100 is 10.00 |
		|  77   | Square root of 77 is 8.77   |
		|  82   | Square root of 82 is 9.06   |