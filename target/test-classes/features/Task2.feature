Feature: List of persons using PO

  Background:
    Given I am on ListPage

  Scenario Outline: add a new person scenario
    When I click Add person button
    And I enter user data: "<name>" "<surname>"
    And I enter date of birth: "<dateOfBirth>"
    And I enter user gender: "<gender>"
    And I enter user information: "<jobTitle>" "<status>"
    And I enter languages: "<languages>"
    Then I click Add button
    Then I check if person added

    Examples:
      | name    | surname    | jobTitle | dateOfBirth | languages | gender | status     |
      | Mihail  | Frolenkov  | QA       | 20/08/1988  | English   | male   | Intern     |
      | Julia   | Shpelkova  | Medic    | 05/06/1994  | Spanish   | female | Employee   |
      | Anatoly | Rapanovich | Worker   | 66/66/6666  | French    | male   | Contractor |


  Scenario: edit a person scenario
    When I click edit person button
    And I enter user data: "Mihail" "Frolenkov"
    And I enter date of birth: "20/08/1988"
    And I enter user gender: "male"
    And I enter user information: "QA" "Intern"
    And I enter languages: "English"
    Then I click Edit button
    Then I check person name changed to: "Mihail" "Frolenkov"


  Scenario: remove a person scenario
    And I click remove person button
    Then I check if person removed


  Scenario: reset after adding person
    When I click Add person button
    And I enter user data: "Julia" "Shpelkova"
    And I enter date of birth: "05/06/1994"
    And I enter user gender: "female"
    And I enter user information: "Doctor" "Employee"
    And I enter languages: "Spanish"
    And I click Add button
    And I check if person added
    Then I click reset button
    Then I check if person removed


  Scenario: reset after editing person
    When I click edit person button
    And I enter user data: "Anatoly" "Rapanovich"
    And I enter date of birth: "10/26/1989"
    And I enter user gender: "male"
    And I enter user information: "Worker" "Contractor"
    And I enter languages: "French"
    And I click Edit button
    And I check person name changed to: "Anatoly" "Rapanovich"
    Then I click reset button
    Then I check person "Anatoly" "Rapanovich" removed


  Scenario: reset after removing person
    When I click remove person button
    And I check if person removed
    Then I click reset button


  Scenario: clear button on adding person
    When I click Add person button
    And I enter user data: "Alex" "Turk"
    And I enter date of birth: "11/27/1985"
    And I enter user gender: "male"
    And I enter user information: "Junior tester" "Intern"
    And I enter languages: "English"
    And I click clear fields button
    Then I check fields cleared
