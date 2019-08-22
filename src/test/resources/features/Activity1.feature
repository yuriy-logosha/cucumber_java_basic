Feature: Open a page "google.lv"
  As a user I want to open page and check elements and text

  Scenario: Open page "google.lv" and check elements
    Given I am on the "google.lv" page
    Then I should see header logo
    And I should see "Es ticu veiksmei!" button
    And I press "Es ticu veiksmei!" button