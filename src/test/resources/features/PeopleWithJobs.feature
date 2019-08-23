Feature: Second task
  As a test engineer
  I want to check the form

  Scenario: add a new person
    Given I am on kristinek Employee page
    When I click on add person button using PO
    And I enter Employee "Jevgenijs" using PO
    And I enter Employee job "Software Test Engineer" using PO
    Then New Employee is added to the database using PO
    And I check does new Employee exists using PO
    When I click on edit person button using PO