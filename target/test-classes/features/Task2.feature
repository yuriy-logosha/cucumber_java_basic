Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters

  Background:
    Given I am on People with jobs page

  Scenario: add a new person
    When I click add person button
    And I enter a name: "<IB>"
    And I enter a job: "<Job>"
    And I click add  button
    Then new person added

  Scenario: I edit a person
    When I click edit button for IB
    And I enter other name: "<Anna>"
    And I click edit button
    Then I see other name

  Scenario: remove a person
    When I choose person
    And I click remove button
    Then person data removes

  Scenario: reset original list after
    When I click add person button
    And I enter a name: "IB"
    And I enter a job: "job"
    And I click add button
    And I click reset list button
    Then I see the list without last entered name

  Scenario: adding a person clear button on adding a user works correctly
    When I click add person button
    And I enter a name: "<Petr>"
    And I enter a job: "<doctor>"
    And I click clear all fields button
    Then Name field and job field are empty

  Scenario: adding a person
  hen I click add person button
    And I enter a name: "<Bill>"
    And I enter a job: "<doc>"
    And I click add  button
    Then new person added


  Scenario: editing a person
    When I click edit button for Jane
    And I enter other name: "<Kate>"
    And I click edit button
    Then I see other name



  Scenario: removing a person
    When I choose person
    And I click remove button
    Then person data removes




