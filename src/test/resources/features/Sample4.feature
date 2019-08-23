@regression @part4
Feature: Introduction to cucumber part 4
  As a test engineer
  I want to be able to write and execute a scenario with steps that have 1 column table

  Background:
    Given I am on age page

  Scenario: a new scenario with 1-row table
    Given I am on action page
    When I clicked on checkboxes:
      | Option 1 |
      | Option 3 |
    And I click the result checkbox button
    Then message for checkboxes "You selected value(s): Option 1, Option 3" is seen

  Scenario: a new scenario with 1-row table
    Given I am on action page
    When I clicked on checkboxes:
      | Option 2 |
    And I click the result checkbox button
    Then message for checkboxes "You selected value(s): Option 2" is seen

    Scenario Outline: a new scenario with 2-row table
      Given I am on action page
      When I clicked on checkboxes <option>
      And I click the result checkbox button
      Then message for checkboxes <message> is seen

      Examples:
        |  option  |  message                       |
        | Option 1 | You selected value(s): Option 1|
        | Option 2 | You selected value(s): Option 2|
        | Option 3 | You selected value(s): Option 3|






