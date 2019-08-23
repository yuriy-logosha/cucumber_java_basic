
Feature: Introduction to cucumber part 4
  As a test engineer
  I want to be able to write and execute a scenario outline with steps

  Background:
    Given I am on action page

  Scenario Outline: a new scenario with 1-row table
    When I clicked on "<checkboxes>"
    And I click the result checkbox button
    Then message for checkboxes "<displayed>" is seen

    Examples:
      | checkboxes         | displayed                                 |
      | Option 1, Option 3 | You selected value(s): Option 1, Option 3 |
      | Option 2           | You selected value(s): Option 2           |

