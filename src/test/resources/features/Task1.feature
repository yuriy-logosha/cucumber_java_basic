@regression
Feature: Number entering check
  As a test engineer
  I want to check that input field and error messages works correctly

  @error_messages
  Scenario Outline: Scenario for error messages
    Given  I am on square root page
    When When I enter number "<number>"
    And Click submit button
    Then I see message: "<message>"
    Examples:
      | number  | message               |
      | 35      | Number is too small   |
      | 133     | Number is too big     |
      | Potter     | Please enter a number |

  @no_error_messages
  Scenario: Scenario for correct number
    Given  I am on square root page
    When I enter value:
      |  80  |
    And I click button
    Then Alert message occurs:
    |Square root of 80 is 8.94|