Feature: Task1
  As a test engineer
  I want to be able to write and execute a scenario with steps that have 2 column tables

  #noinspection GherkinBrokenTableInspection
  Scenario Outline: Scenarios for error cases

    Given I am on age page
    When I enter value: "<value>'
    And I click submit
    Then I see message: "<message>"

    Examples:

      | value| message                  |
      | 20   | Number is too small      |
      | 120  | Number is too big        |
      | hi   | Please enter a number    |


Scenario: new scenario with valid number

  Given I am on age page
  When I enter age: "<age>"
  And I click submit
  Then I see message: "<message>"

  Examples:

      |  age  |  message                   |
      |  78   | Square root of 81 is 9.00  |
