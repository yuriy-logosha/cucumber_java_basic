Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario

  Scenario Outline: for error cases
    When I am on the enter a number page
    Then I enter number: <number1>
    And I click submit button
    And I see message1: "<message1>"
    Examples:
      | number1 | message1              |
      | 1       | Number is too small   |
      | 125     | Number is too big     |
      | text    | Please enter a number |



      Scenario:
        When I am on the enter a number page
        Then I enter number: 55
        And I click submit button
        And I see an alert with message: "Square root of 55 is 7.42"
