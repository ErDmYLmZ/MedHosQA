@UI
@Username_and_Email
Feature: username and email
  Background:
    Given User goes to the URL "https://www.medunna.com"
    And User navigates to the registration page
    And User enters required data up to username field
@TC01
  Scenario Outline: username blank
    Given User leaves the username field blank "<blank>"
    Then User verifies the error massage
    Then User close the application
    Examples:
      | blank |
      |       |
  @TC02
    Scenario Outline:  valid username
      Given User enters a valid username "<validUserName>"
      And User close the application

      Examples:
        | validUserName |
        | qafatih       |
  @TC03
  Scenario Outline:  invalid email blank
    Given User enters a valid username "<validUserName>"
    Given User enters an invalid blank email "<blank>"
    Then User verifies the email error massage
    And User close the application
    Examples:
      | validUserName | blank |
      | qafatih       |       |
  @TC04
  Scenario Outline:  invalid email without @
    Given User enters a valid username "<validUserName>"
    Given User enters an invalid email without @ "<invalidEmail>"
    Then User verifies the email error massage
    And User close the application

    Examples:
      | validUserName | invalidEmail    |
      | qafatih       | qafatihteam.com |
  @TC05
  Scenario Outline:  invalid email without .com
    Given User enters a valid username "<validUserName>"
    Given User enters an invalid email without .com "<invalidEmail>"
    Then User verifies the email error massage
    And User close the application

    Examples:
      | validUserName | invalidEmail    |
      | qafatih       | qafatihteam.com |
  @TC06
  Scenario Outline:  valid email
    Given User enters a valid username "<validUserName>"
    Given User enters a valid email "<validEmail>" and "<password>"
    And user clicks on register button and sees the success message
    And User close the application

    Examples:
      | validUserName | validEmail       | password  |
      | qafatih       | qafatih@team.com | Qa/Fatih1 |