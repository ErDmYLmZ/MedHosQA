@Us008
@UIregistration
Feature: US_008 Password segment on Homepage should be editable

  Background: Navigate to the Homepage
    Given user is on the registration page

  Scenario Outline: Verify password confirmation

    When user enters the first password as "<firstpassword>"
    And user confirms the same password "<confirmationpassword>"
    And Verify error message "<firstpassword>" and "<confirmationpassword>"

      Examples:
        | firstpassword | confirmationpassword |
        | Ab12345.      | Ab12345.             |
        | Ab12345.      | Ab12345              |

  Scenario Outline: Verify strength bar is fully green
    When user enters the first password as "<firstpassword>"
    And user enters "<firstpassword>" and verify the strengthBar is fully green

    Examples:
      | firstpassword |
      | Ab12345.      |
      | AA12345.      |
      | ab12345.      |
      | Abbbbbb.      |
      | Ab123455      |
      | Ab123.        |

    Scenario Outline: old password should not be accepted
      Given user navigates to lending page "<url>"
      And user navigates to sign in portal
      And user clicks on sign in button
      When user provides the username as "<username>"
      And user provides the password as "<password>"
      Then user clicks on login button
      Then user navigates to password
      And User enters current password as "<password>"
      And User enters New password as the same "<password>"
      And User enters New password confirmation as the same "<password>"
      And User clicks on Save button
      Then verify the error message is displayed


      Examples: all data
        | url                 | username | password  |
        | https://medunna.com | admin    | Admin@123 |