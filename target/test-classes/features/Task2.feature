Feature: list of people
  As a test engineer
  I want to be able
  •    add a new person
  •    edit a person
  •    remove a person
  •    reset original list after
  •    adding a person
  •    editing a person
  •    removing a person
  •    check that clear button on adding a user works correctly

  Background:
    Given I am on the home page

  Scenario Outline: Adding person on list
    When add a new person
      | name | <name> |
      | surname  | <surname>  |
    Then I see person on list
    Examples:
      | name  | surname | job      | date of birth | gender |
      | Janis | Berzins | engineer | 01/01/2000    | male   |

Scenario: editing a person
  When i edit persons job: "job"
  Then i see persons job in list

