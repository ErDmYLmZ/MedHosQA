Feature: Create Update and Delete Test Items


  Background:
    Given user navigates to lending page "https://medunna.com"
    And user navigates to sign in portal
    And user clicks on sign in button
    When user provides the username as "sukriye"
    And user provides the password as "Admin1234."
    And user clicks on login button
    Then user clicks on the Item&Title dropdown button and click the Test Item

  Scenario Outline:TC_01 Admin can create new Test Item with valid data
    And Admin click the create new date button as "Create a new Test Item"
    And Admin enter the valid test datas to the textbox as"<name>", "<description>", "<price>", "<defMinValue>", "<defMaxValue>", "<createdDate>"
    Then Verify the new item as "<name>" is displayed on table
    Then Admin should be signOut

    Examples:
      |name       |description|price|defMinValue|defMaxValue|createdDate|successMessage|
      |Cholesterol10|Total      |55   |100        |199        |01/11/2022 |A new Test Item is created with identifier|

  Scenario Outline: TC02 Admin can not be create new Test Item with invalid data
    And Admin click the create new date button as "Create a new Test Item"
    Given Admin enter the invalid test datas to the textbox as"<name>", "<description>", "<price>"
    Then verify the "<errorMessage>" is displayed
    Then Admin should be signOut

    Examples:
      |name       |description|price|errorMessage|
      |Cholesterol10|Total      |  55 |A new Test Item is created with identifier|

  Scenario Outline: TC03 Admin can not be create new Test Item with invalid data
    And Admin click the create new date button as "Create a new Test Item"
    Given Admin left blank the textbox as"<name>","<description>"
    Then verify the name "<invalidFeedback>" is displayed
    Then Admin should be signOut

    Examples:
      |name |description|invalidFeedback         |
      |     | Total      |This field is required.|

  Scenario Outline: TC04 Test Items title should be display
    Given Admin click the create new date button as "Create a new Test Item"
    Then Verify the items as Test Items "<name>", "<description>", "<price>", "<defMinValue>", "<defMaxValue>", "<createdDate>" are displayed
    Then Admin should be signOut
    Examples:
      |name|description|price|defMinValue       |defMaxValue       |createdDate |
      |Name|Description|Price|Default Min. Value|Default Max. Value|Created Date|

  Scenario: TC05 Admin can view the Test Items
    Given Admin click the view button
    Then Verify the "Test Item" Title is displayed
    Then Admin should be signOut

  Scenario: Tc06 Admin can delete the Test Items
    Given Admin click the delete option button
    And Admin click the delete button on the alert
    Then Verify the "DeleteMessage"  delete alert is displayed
    Then Admin should be signOut














