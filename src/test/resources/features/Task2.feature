Feature:
    I am a user and I should be able to add, edit, remove and reset new person.
    I also should be able to clear filled fields at the adding the person form.

Background:
Given I am on page people with jobs

      Scenario: add a person
        When I click add a person
        And I am on page Add Person
        And I enter name: "<Bob>"
        And I enter job: "<Salesman>"
        And I click button Add
        And I am on page people with jobs
        Then I see new person Bob

      Scenario: edit a person
        When I click on edit a person Mike
        And I am on page edit Mike
        And I enter name: "<Michael>"
        And I click button Edit
        And I am on page people with jobs
        Then I see person Michael instead of Mike

      Scenario: remove a person
       When I click on remove a person Jill
       Then There is no Jill in the list anymore

      Scenario:  reset original list after
       When I click on Reset List
       Then I see Jill again

      Scenario: adding a person
       When I click add a person
       And I enter name: "<Jack>":
       And I enter job: "<cleaner>"
       And I click button Add
        And I am on page people with jobs
       Then I see new person Jack

      Scenario: editing a person
         When I click on edit a person Jack
         And I am on page edit Jack
         And I enter name: "<Richard>":
         And I click button Edit
         And I am on page people with jobs
         Then I see new person Richard

      Scenario: removing a person
        When I click on remove a person Richard
        Then there is no Richard anymore

      Scenario:  check that clear button on adding a user works correctly
        When I click add a person
        And I enter name: "<Vova>":
        And I enter job: "<Musician>"
        And I click Clear all fields
        Then name and job fields are clear again