Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario

  Background:
    Given   I am on the people with jobs

  Scenario Outline: Add a new person
    When I click on add person button
    And  I enter user name: "<name>"
    And  I enter user surname: "<surname>"
    And  I enter job: "<job>"
    And  I enter date of birth: "<dateOfBirth>"
    And  I tick language: "<language>"
    And  I choose gender: "<gender>"
    And  I choose status: "<status>"
    And  I click add button

    Examples:
      | name | surname | job      | dateOfBirth | language | gender | status   |
      | Joey | Hadar   | engineer | 19/07/1990  | English  | male   | employee |
      | Fiat | Heyday  | lawyer   | 04/01/1997  | English  | female | intern   |

  Scenario: Editing Person
    When I click edit person button
    Then I enter user name: "Jon"
    And I click edit button

  Scenario: Removing person
    And I click remove button

  Scenario: Reseting list
    And I reset list


  Scenario Outline: adding a person
    When I click on add person button
    Then  I enter user name: "<name>"
    And  I enter user surname: "<surname>"
    And  I enter job: "<job>"
    And  I enter date of birth: "<dateOfBirth>"
    And  I tick language: "<language>"
    And  I choose gender: "<gender>"
    And  I choose status: "<status>"
    And  I click add button
    Examples:
      | name | surname | job     | dateOfBirth | language | gender | status     |
      | Mike | Snow    | teacher | 12/09/1989  | Spanish  | male   | Contractor |

  Scenario: editing a person
    When I click edit person button
    Then I enter job: "waiter"
    And I click edit button

  Scenario: Removing person
    And I click remove button

  Scenario: Clearing fields
    Then I clear all fields

