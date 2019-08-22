Feature: Open page
As a user I want to open page so I can see the news

	Scenario: Open page and see some news items as well as news tab on the header menu list
		Given I am on google webpage
		When I enter word "Apple" in the search bar
		And press search button
		Then I should see some results