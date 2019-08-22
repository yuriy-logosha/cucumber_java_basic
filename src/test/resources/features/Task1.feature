Feature: In Task1.feature create 1 scenario outline and 1 scenario for page with
  url: "https://kristinek.github.io/site/tasks/enter_a_number"
  •    Scenario outline for error cases:
  o    enter number too small
  o    enter number too big
  o    enter text instead of the number
  •    Scenario for correct number

 Scenario Outline: a new scenario outline
   Given I am on sample page
   When enter "<numb>"
   And I click submit
   Then I see message "<msg>"

   @not_working
   Examples:
     | numb  | msg                   |
     | 4     | Number is too small   |
     | 101   | Number is too big     |
     | Marry | Please enter a number |

  Scenario Outline: a new scenario outline
    Given I am on sample page
    When enter "<numb>"
    And I click submit
    Then I see accepted message "<msg>"

    @working
    Examples:
      | numb  | msg                         |
      | 81    | Square root of 81 is 9.00   |

