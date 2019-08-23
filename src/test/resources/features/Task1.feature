Feature: Second task
  As a test engineer
  I want to check functional of person list
  Background:
    Given I am on people list page

  Scenario Outline: : Add new person
    When  I click add new person button
    And  I enter person name: "<name>"
    And  I enter person job: "<job>"
    And I click Add button
    Then I see new person in list
  Examples:
      | name  | job |
      | Ann   | Boss  |

   Scenario: Edit a person
     When I click correct button
     And  I enter person name: "<Test>"
     And  I enter person job: "<Test>"
     And I click Edit button
     Then Person name and job should be changed