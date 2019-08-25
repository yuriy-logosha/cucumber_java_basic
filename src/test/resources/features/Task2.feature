Feature: Task2
  As a test engineer
  I want to be able to write and execute a scenario for users functions

  Background:
    Given I am on people with jobs page

    #    add a new person

  Scenario Outline: add a new person

    When I click add person
    And I am on adding page
    And I enter "<Name>" in name field
    And I enter "<Job>" in job field
    And I click add
    Then I see a new person

    Examples:
      | Name | Job    |
      | Zina | manager|
  
#•    edit a person
#•    remove a person

    Scenario: edit and remove person

      When I click edit
      And I am on editing page
      And I enter another "<Name>" in name field
      | Masha |
      And I click edit again
      And I see edited person
      And I click delete edited person from the list
      Then I see edited person is removed

      #•    reset original list after

    Scenario: reset list

    When I click on reset
    Then I see the same list of persons

      #•    adding a person

    Scenario Outline: add a person

      When I click add person
      And I am on adding page
      And I enter "<Name>" in name field
      And I enter "<Job>" in job field
      And I click add
      Then I see a new person

      Examples:
        | Name | Job    |
        | Dina | tester |

      #•    editing a person
      #•    removing a person

      Scenario: edit and remove person

     When I click edit
     And  I enter another "<Job>" in job field
       | developer |
     And I click edit again
     And I see edited person
     And I click on delete person
     Then I see edited person is removed

#•    check that clear button on adding a user works correctly

       Scenario Outline: check clear button works correctly

         When I click add person
         And I enter "<Name>" in name field
         And I enter "<Job>" in job field
         And I click clear all fields
         Then I see all fields are cleared

         Examples:
           | Name  | Job        |
           | Marina| accountant |
