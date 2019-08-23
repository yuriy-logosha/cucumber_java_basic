
Feature: Square root
  As a test engineer
  I want to be able to easy calculate a square root

  Scenario: Opening calculator home page
    When I am on the calculator home page
    Then I enter number too small and press Submit button
    And I see error message that number is too small
    Then I enter number too big and press Submit button
    And I see error message that number is too big
    Then I enter text and press Submit button
    And I see error message that we need number to be entered
    Then I enter correct number and press Submit button
    And I see square root calculations results

