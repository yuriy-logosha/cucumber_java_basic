Feature: Task1 scenario
  As a TA Student
  I am testing the Enter a Number form

  Background:
    Given I am on the Enter a Number form

  Scenario Outline: Testing the incorrect values
    When I enter value:
    |value|<value>|
    And I click the submit button
    Then I see error message: "<message>"
    Examples:
    |value|message|
    |33   |Number is too small|
    |111  |Number is too big  |
    |text |Please enter a number|

  Scenario: Testing correct values
    When I enter value:
    |96|
    And I click the submit button
    Then I see alert with result:
    |Square root of 96 is 9.80|