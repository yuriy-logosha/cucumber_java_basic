@regression
Feature: Formating people with job table
  As a test engineer
  I want to check that user can add a new person, edit a person, remove a person,
  reset original list after adding, editing, removing a person
  and check that clear button on adding a user works correctly

  Background:I am on People with job page

  Scenario Outline: Add person button correct work
    When I click Add person button
    And I input <name>
    And I input <job>
    And I click Add button
    Then new person displays on the list
    Examples: