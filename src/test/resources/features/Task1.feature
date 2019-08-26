Feature: Square root test
  As a test engineer
  I want to check square input field results

  @FailedScenario
  Scenario Outline: Entered incorrect number
    Given Open webpage
    When  Number: "<number>" is entered
    And Click submit button
    Then  Assert result error: "<message>"

    Examples:
      | number | message               |
      | 35     | Number is too small   |
      | 172    | Number is too big     |
      | qwerty | Please enter a number |


  @SuccessfulScenario
  Scenario Outline: Entered correct number
    Given Open webpage
    When Number: "<number>" is entered
    And Click submit button
    Then  Assert correct result "<message>"

    Examples:
      | number | message                   |
      | 60     | Square root of 60 is 7.75 |
      | 81     | Square root of 81 is 9.00 |


