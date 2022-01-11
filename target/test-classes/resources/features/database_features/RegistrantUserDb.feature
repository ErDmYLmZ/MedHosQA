Feature: Database test
  Background:
    Given user creates a connection with DB using "jdbc:postgresql://medunna.com:5432/medunna_db" , "medunnadb_user" and "Medunnadb_@129"
  @DBtesting
  Scenario Outline: Database testing
    Given user sends the query to db and gets the column data "<query>" and "<columnName>"
    And user saves the DB data to correspondent files
    Then user validates DB data
    Examples: DB data manipulation
      |query|columnName|
      |Select * from jhi_user|ssn|