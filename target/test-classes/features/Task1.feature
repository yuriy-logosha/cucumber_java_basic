Feature: Sample page number input

  @NegativeScenarioOutline
  Scenario Outline:  New scenario outline
    Given Sample page in browser
    When I enter incorrect value: <value>
    And I click submit
    Then I see error message: <message>
    @negative
    Examples:
      | value | message               |
      | 1     | Number is too small   |
      | 101   | Number is too big     |
      | x     | Please enter a number |

  @ValidScenarioOutline
  Scenario Outline:  New scenario outline
    Given Sample page in browser
    When I enter incorrect value: <value>
    And I click submit
    Then I see alert message: <message>
    @valid
    Examples:
      | value | message                   |
      | 64    | Square root of 64 is 8.00 |
      | 81   | Square root of 81 is 9.00 |
      | 100    | Square root of 100 is 10.00 |


