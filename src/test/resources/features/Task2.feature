Feature: Task2 Scenario Outlines
  As a TA Student
  I am testing the List of People page

  Background:
    Given I am on List of People page

  Scenario Outline: Adding a person
    When I check current list
    And I click Add Person button
    And I fill the input fields:
    |name    |<name>   |
    |surname |<surname>|
    |job     |<job>    |
    |dob     |<dob>    |
    |status  |<status>  |
    |language|<language>|
    |gender  |<gender>  |
    And I click Add button
    Then Another person should be listed
    Examples:
      |name    |surname    |job    |dob       |language|gender|status|
      |TempName|TempSurname|TempJob|23/08/2019|french  |male  |intern|