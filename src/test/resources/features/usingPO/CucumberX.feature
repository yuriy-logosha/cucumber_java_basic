Feature: CucumberX
  As a test engineer
  I want to be able to write and execute a simple scenario

  Scenario: Check for elements on page
    When I open google.com
    Then I should see search bar
    And Click on the search bar
    And Enter ''Cucumber'' in the search bar
    And Press search button
    Then Information shows up about the subject


