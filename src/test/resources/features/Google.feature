  Feature:  google page test

    Background:  I am on google page
      Given I am on google page

    Scenario Outline: I search for milk
      When I open goolge page
#      Then I see Es ticu veiksmei!
      And I search for "<item>"

      And I click search
#      When I selects filters:
#        | name      | value |
#        | <f1_name> | <f1_value> |
#        | <f2_name> | <f2_value> |
#      Then I should see:
#        | items |
#        | <result> |
      Examples:
#        | item | f1_name | f1_value | f2_name | f2_value | result |
        | milk | f1_name | f1_value | f2_name | f2_value | result |

