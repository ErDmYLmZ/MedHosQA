@RegistrationPassword
Feature: Registration Password

  Background:
    Given User goes to url

  @UIlogin
  Scenario Outline: Verify the password is secure
      Given User navigates to Registration Page
      And user enters a new password as "<password>"
      Then Verify the strength bar is green

      Examples:
      |password|
      |Ab12345|
      |aBc1234|
      |Ab1cdef|
      |Ab1234.|
      |Ab12345.|

  @UIlogin
  @UIRegistrationPasswordNegative
  Scenario: User enters weak password
      Given user is on the Registration page
      And user enters a password as "Ab123."
      Then Verify Verify the strength bar is red



