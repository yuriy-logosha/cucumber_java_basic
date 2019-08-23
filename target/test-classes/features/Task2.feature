Feature: create 1 scenario outline and
  create scenario or scenario outlines for page https://kristinek.github.io/site/tasks/list_of_people
  in order to test that user can:
  •    add a new person
  •    edit a person
  •    remove a person
  •    reset original list after
  •    adding a person
  •    editing a person
  •    removing a person
  •    check that clear button on adding a user works correctly

  Background:
    Given I am on task page

    Scenario: a new person
      When I click add person
      Then I see new page

  Scenario: a edit person
    When I click edit person
    Then I see new edit page

  Scenario: a remove person
    When I click remove person
    Then I see new remove page

  Scenario: reset original list after
    When I click remove person
    Then I see new remove page
    When I click reset list
    Then I see reset page

  Scenario: adding a person
    When I click add person
    And I enter person values
      | name | Ann |
      | job  | QA  |
    And I click add
    Then I see person

  Scenario: editing a person
    When I click add person
    And I enter person values
      | name | Ann |
      | job  | QA  |
    And I click add
    Then I see person
    When I click edit new person
    And I enter person new values
      | name | Ann |
      | job  | CEO |
    And I click add
    Then I see person

  Scenario: a remove person
    When I click add person
    And I enter person values
      | name | Ann |
      | job  | QA  |
    And I click add
    And I see person
    And I click remove new person
    Then I see person removed

  Scenario: check that clear button on adding a user works correctly
    When I click add person
    And I enter person values
      | name | Ann |
      | job  | QA  |
    And I check fields
    And I click clear button
    Then I see empty fields



