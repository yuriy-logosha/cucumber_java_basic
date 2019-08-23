Feature: Enter a number

  Scenario Outline: Enter a too small number0
    Given I am on enter a number0 page
    Then I should see enter a number0 Tab window
    And I click on enter number0 window
    When I enter "<numbers>" too small:
    Examples:
      | Numbers |
      | 1       |
      | 11      |
      | 30      |
      | 49      |
    And I click on Submit
    Then I see message Number is too small