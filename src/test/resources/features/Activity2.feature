@regression @part4
Feature: Introduction to cucumber part 4
  As a test engineer
  I want to be able to write and execute a scenario with steps that have 1 column table
  
  
  Scenario Outline: I click on checkboxes in different configurations
    Given I am on action page
    When I select the checkboxes:
      |  name      |  selected    |
      | Option 1   | <selected_1> |
      | Option 2   | <selected_2> |
      | Option 3   | <selected_3> |
    And I click the result checkbox button
    Then message for checkboxes "<message>" is seen
	Examples:
		| selected_1 | selected_2 | selected_3 | message                                             |
		|  true      |            |            | You selected value(s): Option 1                     |
		|            |  true      |            | You selected value(s): Option 2                     |
		|            |            |  true      | You selected value(s): Option 3                     |
		|  true      |  true      |            | You selected value(s): Option 1, Option 2           |
		|  true      |            |  true      | You selected value(s): Option 1, Option 3           |
		|            |  true      |  true      | You selected value(s): Option 2, Option 3           |
		|  true      |  true      |  true      | You selected value(s): Option 1, Option 2, Option 3 |
		|            |            |            | You had not selected anything                       |

