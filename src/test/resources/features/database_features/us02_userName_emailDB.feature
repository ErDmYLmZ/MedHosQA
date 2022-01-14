
Feature:UserName and Email DB testing
  Background:DB testing
    Given user create a connection with DB using "jdbc:postgresql://medunna.com:5432/medunna_db" , "medunnadb_user" and "Medunnadb_@129"

  @DBtesting
  @TC09_UsernameAndEmail
  Scenario Outline: Database userName and email testing
    Given user send the query to db and gets the column data "<query>" and "<columnName>",  "<columnName2>"
    And user save the DB data to correspondent files
    Then user validates userName and email in DB

    Examples: DB data manipulation
      | query                  | columnName |columnName2|
      | Select * from jhi_user | email      |login      |