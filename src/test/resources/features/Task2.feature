@regression
Feature: Formating people with job table
  As a test engineer
  I want to check that user can add a new person, edit a person, remove a person,
  reset original list after adding, editing, removing a person
  and check that clear button on adding a user works correctly

  Background:
    Given I am on People with job page

  Scenario Outline: Adding person
    When I click Add person button
    And I enter name: "<name>"
    And I enter job: "<job>"
    And I click Add button
    Then new person displays on the list
    Examples:
      | name | job    |
      | Anna | Tester |
      | Bob  | Admin  |

  Scenario Outline: Editing person
    When I click edit icon
    And I enter another name: "<name>"
    And I enter another job: "<job>"
    And I click Edit button
    Then edited person displays on the list
    Examples:
      | name | job  |
      | Olga | Boss |

  Scenario: Removing person
    When I click removing icon
    Then selected person is deleted

