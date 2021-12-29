@Us008
Feature: US_008 Password segment on Homepage should be editable
  Background: Navigate to the Homepage
    Given user is on the registration page

    Scenario Outline: Verify password confirmation
    When user enters the password as "<firstpassword>"
    And user confirms the new password "<secondpassword>"
    And Verify error message
      Examples:
      |firstpassword|secondpassword|
#      |Ab12345.     |Ab12345.      |
      |Ab12345.     |Ab12345       |