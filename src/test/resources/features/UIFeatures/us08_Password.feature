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

    Scenario: old password
      When user reads all registrant datam