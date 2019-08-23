@regression @part4
Feature: Introduction to cucumber part 4
  As a test engineer
  I want to be able to write and execute a scenario with steps that have 2 column tables

  Background:
    Given I am on age page using PO

Scenario Outline: a new scenario outline 2
When I enter values using PO:
| name | <name> |
| age  | <age>  |
And I click submit age using PO:
Then I see message: "<message>" using PO
Examples:
| name | age | message                      |
| Ann  | 5   | Hello, Ann, you are a kid    |
| Bob  | 61  | Hello, Bob, you are an adult |