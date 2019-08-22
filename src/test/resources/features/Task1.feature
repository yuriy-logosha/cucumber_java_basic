Feature: Scenario outline for error cases

  Scenario outline for error cases:
    Given i am on page
    When i enter number too small
    Then error
    When i enter number too big
    Then error2
    When i enter text
    Then error3
    When i enter correct number
    Then result