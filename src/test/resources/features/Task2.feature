Feature: Testing page "list with people and jobs"
  As a test engineer I want to test buttons and adding new person function

  Background:
    Given I am on the list with people and jobs page

  Scenario Outline: Adding a new person
    When I click Add person button
    And I enter values:
      |  name  |  <name>  |
      |  job   |  <job>   |
    And I click Add button to add
    Then I see that new person and job added
    Examples:
      |  name   |  job      |
      |  Irina  | Tester    |

  Scenario: Edit a person
    When I click on person Pencil button
    And I change name add letter A at the end for editing
    And I click on Edit button
    Then I see changed Mike name

  Scenario: Remove a person
    When I click on zero person Delete button
    Then I see zero person is deleted after remove


  Scenario: Add and reset
    When I click add person button for reset
    And I enter Irina name and Tester job for reset
    And I click add button to reset
    And I click Reset List button after add
    Then I see list is reset after add

  Scenario: Edit and reset
    When I click on zero person pencil button
    And I change name add letter A at the end before reset
    And I click on edit button before reset
    And I see changed Mike name before reset
    And I click Reset List button after edit
    Then I see list is reset after edit

  Scenario: Remove and reset
    When I click on zero person delete button before reset
    And I see zero person is deleted before reset
    And I click Reset List button after remove
    Then I see list is reset after remove

  Scenario: Add and clear
    When I click add person button for clear
    And I enter Irina name and Tester job for clear
    And I click Clear all fields button
    Then I check fields are empty