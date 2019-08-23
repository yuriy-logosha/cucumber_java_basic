Feature: Second task
  As a test engineer
  I want to check square input field results

  Background:
    Given I am on listofpeople page

  Scenario: Add a new person
    When  I click Add a new person
    And Enter Person Data:
      |name| Bob |
      |job| Accountant |
    And I click Add
    Then I see element:"Bob"

  Scenario: Edit a person info
    When  I click on edit 'pencil' button
    And Enter New person Data:
      |name| Lemmy |
      |job| Guitarist |
    And I click on edit button
    Then I see element changed:"Lemmy"

  Scenario: Remove a person
    When  I click remove person button and Remove Lemmy
    Then I check that name is removed:"Mike"



