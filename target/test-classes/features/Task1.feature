@Task1
Feature
  As a test engineer
  I want to be able to write and execute a scenario with steps that have 2 column tables

  Scenario Outline: for error cases
    Given I am on Enter a number page
    When I enter value: <value>
    And   I click submit
    Then  I see message: "<message>"
    Examples:
      | value | message               |
      | 10    | Number is too small   |
      | 105   | Number is too big     |
      | mike  | Please enter a number |

  Scenario for correct number
    Given I am on Enter a number page
    When I enter value: <value>
    And   I click submit
    Then  I see message: "<message>"

      |       | message                   |
      | 64    | Square root of 64 is 8.00 |
