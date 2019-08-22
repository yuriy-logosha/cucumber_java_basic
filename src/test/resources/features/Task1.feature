
Feature: Entering numbers gives correct response
  As a test engineer
  I want to be able to execute positive and negative scenarios with numbers

  Background:
    Given I am on Enter a number page

  Scenario Outline: error cases
    When I enter number: "<number>"
    And I click Submit
    Then I see error message: "<errorMessage>"
  @error
    Examples:
      | number | errorMessage            |
      | 48     | Number is too small     |
      | 101    | Number is too big       |
      | five   | Please enter a number   |

  Scenario: correct case
    When I enter number: "81"
    And I click Submit
    Then I see alert: "Square root of 81 is 9.00"