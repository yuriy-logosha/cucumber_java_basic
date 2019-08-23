Feature: Second task
  As a test engineer
  I want to check square input field results

  Scenario Outline: outline for error cases
    Given I am on kristinek page
    When When I enter number "<number>"
    And I click submit button
    Then  I see result in alert: "<message>"
    @working
    Examples:
      | number | message                     |
      | 50     | Square root of 50 is 7.07   |
      | 100    | Square root of 100 is 10.00 |
      | 75     | Square root of 75 is 8.66   |