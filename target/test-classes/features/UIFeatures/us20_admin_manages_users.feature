@us20_admin_manages_users

Feature: US20 Admin manages users

  @UIlogin
  Scenario Outline: TC01 Admin verifies people info

    Given Admin goes to the url
    And Admin should navigate to sign in page
    And Admin enters username "<username>"
    And Admin enters password "<password>"
    And Admin clicks sign in button
    And Admin clicks Administration dropdown, selects User management and clicks
    And Admin clicks view button of an existing user "<user1>"
    Then admin verifies registered people info as firstname, lastname, email etc.

    Examples: test data
      | username | password | user1 |
      | great    | Ab12345. | great |

  Scenario Outline: TC02 Admin edits user info

    Given Admin goes back to the Users page
    And Admin clicks Edit button of an existing user "<user2>"
    And Admin edits the info, activates the account and gives role
    And Admin clicks save button
    Then Admin sees success message and verifies Users text as navigates back to that page
    Examples: test data
      | user2 |
      | test2 |

  Scenario Outline: TC03 Admin deletes account

    Given Admin is on the Users page
    And Admin clicks delete button of a user "<user3>"
    And Admin gets Confirm delete operation message box
    Then admin verifies the success message and gets back to Users page

    Examples: test data
      | user3 |
      | test2 |