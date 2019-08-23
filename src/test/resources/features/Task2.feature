Feature:  finish Task 2
  As a test engineer
  I want to be able to understand Cucumber structure

  Background:
    Given I am on the main job page
    And I click button - add person


  Scenario Outline:  reset original list
    When I Enter data in creating new person
      | name | <name>|
      | surname | <surname>|
      | job     | <job>    |
    |  date of birth| <date of birth>|
    | language      | <language>     |
    |gender         | <gender>       |
    | employee status| <employee status>|
    And I press add
    And I press edit Button
    And I change the name

    When I remove the person
    And I press button reset list
    Then I see the original list

    Examples:
      | name | surname| job  | date of birth | language | gender | employee status |
      | Anna | Ivanova|tester| 13/06/1994    | English  | female | Employee        |


  Scenario Outline: Clear button check
    When Enter data that I will change
      | name | <name>|
      | surname | <surname>|
      | job     | <job>    |
      |  date of birth| <date of birth>|
      | language      | <language>     |
      |gender         | <gender>       |
      | employee status| <employee status>|
    And I press clear all field button
    Then I see all fields are empty

    Examples:
      | name | surname | job   | date of birth | language | gender | employee status |
      | Anna | Ivanova | tester| 13/06/1994    | Spanish  | female | Intern          |

