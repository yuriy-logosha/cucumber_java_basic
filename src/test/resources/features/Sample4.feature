@regression @part4
Feature: Introduction to cucumber part 4
  As a test engineer
  I want to be able to write and execute a scenario for action page

  Background:
    Given I am on age page

  Scenario Outline: a new scenario for actions page
    Given I am on action page
    When I clicked on checkboxes:
      | <option1> |
      | <option2> |
    And I click the result checkbox button
    Then message for checkboxes
    | <result> |
    Examples:
    | option1  | option2   | result                                     |
    | Option 1 |  Option 3 | You selected value(s): Option 1, Option 3 |
    | Option 2 |           | You selected value(s): Option 2           |






