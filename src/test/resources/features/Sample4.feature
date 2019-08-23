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

  Scenario: a new scenario with 1-row table
    Given I am on action page
    When I clicked on checkboxes:

    | <option1> |
    | <optiob2> |


    And I click the result checkbox button
    Then I should see message "<message>"
    | <message> |


    ExamplesExamples:

    | option 1    | option 2   | message                                  |
    | <option1>   | <option 3> | You selected value(s):Option 1, Option 3 |
    | <option2>   |            | You selected value(s): Option 2          |
