@regression
Feature: Number entering
  As a test engineer
  I want to check that input field and error messages works correctly

  @error_messages
  Scenario Outline: Scenario for error cases
    Given  I am on number page
    When I enter number: "<number>"
    And I click submit button
    Then I see message: "<message>"
    Examples:
      | number  | message               |
      | 47      | Number is too small   |
      | 150     | Number is too big     |
      | Bob     | Please enter a number |

    @no_error_messages
  Scenario: Scenario for correct number
    When I enter value:
      | number     |  77  |
    And I click button
    Then I do not see any error message
