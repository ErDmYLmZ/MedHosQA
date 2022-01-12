@UserManagement
Feature: User management UI test
  @UIlogin
  Scenario Outline: login functionality
    Given user navigates to lending page "<url>"
    And user navigates to sign in portal
    And user clicks on sign in button
    When user provides the username as "<username>"
    And user provides the password as "<password>"
    Then user clicks on login button
    Examples: all data
      |url|username|password|
      |https://medunna.com|admin|Admin@123|

  Scenario Outline: user management test
    Given user navigates to user management panel
    And user provides username "<userName>" and "<SSN>" and "<email>"
    Then user validates current activities
    Examples:
      | userName | SSN | email |
      |ahmet      |049-73-6092|fatihkemal@gmail.com|
