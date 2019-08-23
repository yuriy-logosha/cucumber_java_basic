@regression @part4
Feature: Introduction to cucumber part 4
  As a test engineer
  I want to be able to write and execute a scenario with steps that have 1 column table

  Background:
    Given I am on action page

  Scenario Outline: a new scenario with 1-row table
    When I clicked on checkboxes:
      | <option1>|
      | <option2>|
    And I click the result checkbox button
    Then message for checkboxes is seen
           |<result>|


    Examples:
             |       option1           |option2     | result                                      |
             |  Option 1               | Option 3   | "You selected value(s): Option 1, Option 3" |
             |    Option 2             |            | "You selected value(s): Option 2"           |


