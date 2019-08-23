@regression @part4
Feature: Introduction to cucumber part 4
  As a test engineer
  I want to be able to write and execute a scenario with steps that have 1 column table

  Background:
    Given I am on age page

  Scenario Outline: a new scenario with 1-row table
    Given I am on action page
    When I clicked on checkboxes:
      | Option 1 |
      | Option 2 |
      | Option 3 |
    And I click the result checkbox button
    Then checkbox "<message>" is seen
    Examples:
    | message |
    | You selected option: Option 1 |
    | You selected option: Option 2 |
    | You selected option: Option 3 |



