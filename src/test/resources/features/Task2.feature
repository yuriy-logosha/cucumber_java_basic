Feature: People test
  As a test engineer
  I want to check list of people

  Background:
    Given Open list of people page

  Scenario Outline: Adding new person
    When click on 'add person' button
    And set name as "<name>"
    And set surname "<surname>"
    And set job "<job>"
    And set date of birth "<dateOfBirth>"
    And set language "<language>"
    And set gender "<gender>"
    And set employee status "<status>"
    Then click on add button
    Then assert new person was added with name "<name>" "<surname>" and job "<job>" and status "<status>"
    And assert new person date of birth "<dateOfBirth>", language "<language>" and gender "<gender>"

    Examples:
      | name    | surname | job | dateOfBirth | language | gender | status |
      | Nellija | Milka   | QE  | 19/03/1996  | spanish  | female | intern |


  Scenario Outline: Editing existing person
    When click on edit person "<personIndex>"
    And set name as "<name>"
    And set surname "<surname>"
    Then click on edit button
    And assert person "<personIndex>" have name "<name>" and "<surname>"

    Examples:
      | personIndex | name | surname |
      | 2           | John | Snow    |

  Scenario: Deleting existing person and reset list
    When select person 1
    Then click on delete person 1
    And assert selected person was removed
    Then click on reset list
    And assert person list is of size 3
    And assert selected person was not removed


