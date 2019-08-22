Feature: Sample page input
@debugs
  Scenario Outline:  New scenario outline
  Given Sample page in browser
    When I enter incorrect value: <value>
    And I click submit
    Then I see error message: <message>
    @working
    Examples:
      | value | message                        |
      | 1   | Number is too small     |
      | 101  | Number is too big |
      | x  | Please enter a number   |
     @working
     Scenario Outline:  New scenario outline
       Given Sample page in browser
       When I enter incorrect value: <value>
       And I click submit
       Then I see alert message: <message>
   Examples:
    | value | message                   |
    | 64  | Square root of 64 is 8.00 |


