
Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters

Background:

  Scenario Outline: scenario invalid number
  Given I am on the Enter a number page

When I enter invalid number: "<number>"
And I click submit button
Then I see the message: "<message>"

Examples:
| number       |  message                |
| 3            | Number is too small     |
| 300          | Number is too big       |
| notNumber    | Please enter a number   |





