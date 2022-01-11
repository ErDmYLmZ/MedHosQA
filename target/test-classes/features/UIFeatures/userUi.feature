@UIlogin
@UIUserSettings
Feature: User info segment should be editable on Homepage

  Background:
    Given login with "staff" account
    And user navigate page "settings"

  Scenario: Update firstname and lastname
    And Change firstname lastname
    Then verify if they are changed


