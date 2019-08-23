Feature: Task2
  As a test engineer
  I want to be able to write and execute a scenario for users functions

  Background:
    Given I am on people with jobs page

    #    add a new person

  Scenario Outline: adding a new person

    When I click on add person
    And I enter "<Name>" in name field
    And i enter "<Age>" in age field 

#  Scenario Outline: Admin user enter correct data
#    When user enters “<username>” in username field
#    And user enters “<password>” in password field
#    Then “Welcome, <username>” is seen
#    @regressionTest
#    Examples:
#      | username | password |
#      | admin | admin |
#  @smokeTest

  
  
#•    edit a person
#•    remove a person
#•    reset original list after
#•    adding a person
#•    editing a person
#•    removing a person
#•    check that clear button on adding a user works correctly

