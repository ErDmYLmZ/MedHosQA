Feature: Registration


  @UIregistration
  Scenario Outline: Register new users for Medunna
    Given user is on the registration page
    And user enters ssn number as "<SSN>"
    Then user enters firstname and lastname as "<firstname>" and "<lastname>"
    And user provides a username "<username>"
    Then user provides email id as "<email>"
    When user enters the password as "<firstpassword>"
    And user confirms the new password "<secondpassword>"
    Then user clicks on register button and sees the success message as "<message>"
    Then user reads all registrant data
    Examples:
      |SSN|firstname|lastname|username|email|firstpassword|secondpassword|message|
      |563-26-3726|Bahar|trk|sdet|bhrturk@gmail.com|Bhr@123?|Bhr@123?|Registration saved|

  Scenario:  TC02-SSN should not be invalid number
    Given user is on the registration page
    And user enter invalid ssn "ssn" number
    Then validate invalid ssn feedback "message" is appeared

  Scenario: TC03- SSN can not be left blank
    Given user is on the registration page
    And user left ssn "ssn" numberbox blank
    Then validate invalid ssn feedback "message" is appeared


  Scenario Outline: TC04- SSN number should be unique
    Given user is on the registration page
    And user enters same ssn number as "<SSN>" and different person's data "<firstname>" and "<lastname>","<username>","<email>","<firstpassword>","<secondpassword>"
    Then user clicks on register button and sees the failure message as "<failMessage>"
    Examples:
      |SSN|firstname|lastname|username|email|firstpassword|secondpassword|failMessage|
      |563-26-3726|Baris|Manco|KurtulanExpress|barismanco@gmail.com|Brs@123?|Brs@123?|This SSN has been registered for another user!|

  @UIregistration
  Scenario Outline:  TC05- First name can not be blank
    Given user is on the registration page
    And user enters ssn number as "<SSN>"
    And user left blank first name"<firstname>"
    Then validate invalid first name feedback "<message>" is  appeared

    Examples:
      |SSN|firstname|message|
      |   |         |Your FirstName is required.|

  @UIregistration
  Scenario Outline:  TC06-Last name can not be blank
    Given user is on the registration page
    And user enters ssn number as "<ssn>"
    And user enters the first name"<firstname>"
    Then user left last name blank "<lastname>"
    Then validate invalid last name feedback "<message>" is appeared

    Examples:
      |ssn|firstname|lastname|message|
      |   |         |        |Your LastName is required.|



