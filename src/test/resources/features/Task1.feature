Feature: Enter number page - testing
  As a test engineer I want to enter range of different numbers

  Background:
    Given I am on the number entering page

  Scenario Outline: Incorrect range is entered
    When I enter input: "<input>"
    And I click submit button
    Then I should see error message: "<message>"
    Examples:
      | input | message                        |
      |  20   | Number is too small            |
      |  200  | Number is too big              |
      |       | You haven't entered anything   |
      |  ji   | Please enter a number          |

  Scenario Outline: Correct range is entered
    When I enter input: "<input>"
    And I click submit button
    Then I should receive an alert message: "<message>"
    Examples:
      | input | message                     |
      |  81   | Square root of 81 is 9.00   |
      |  90   | Square root of 90 is 9.49   |
