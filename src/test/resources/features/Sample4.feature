@regression @part4
Feature: Introduction to cucumber part 4
  As a test engineer
  I want to be able to write and execute a scenario with steps that have 1 column table

  Background:
    Given I am on action page

    Scenario Outline: new scenario outline for options
      When I clicked on checkboxes: <option>
      And I click the result checkbox button
      Then <message> for checkboxes is seen
      Examples:
        | option  |             message                       |
        |  1 # 3  | You selected value(s): Option 1, Option 3 |
        |  2      | You selected value(s): Option 2           |


