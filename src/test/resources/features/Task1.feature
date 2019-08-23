
Feature: Finish Task 1
  As a test engineer
  I want to be able to understand Cucumber strucure

  Scenario Outline: for error cases:
    When I am on the main page
When I enter wrong number or symbols: "<number>"
    And I click on submit button
    Then I see: "<error message>"
    Examples:
    |number| error message|
    | 24   | Number is too small |
    |104   | Number is too big   |
    | brr | Please enter a number |

  Scenario : for correct number:
    When I enter correct number: "66"
    And I click on submit button1
    Then there is no error displayed

