Feature: User_Needs_To_Validate_All_Patient_Info_From_DB



  @DBtesting
  Scenario Outline: Database testing Patient
  Given user sends the query to db and gets the patient data "<query>"
  And user saves the DB Patient data to correspondent files
  Then user validates DB Patient data

    Examples: DB data manipulation
      | query                   |
      | select * from patient   |



#  User creates connection with DB
#  User sends their query to DB and gets related data
#  User sets DB data into correspondent files
#  User validates DB data using records



#  Scenario: TC_02901_user connects database
#    Given user connects to the database
#    And user reads all users' info.
#    Then validate  all users
