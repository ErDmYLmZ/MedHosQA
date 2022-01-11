Feature: DB user data test



    @DBtesting
    Scenario Outline: Database testing
    Given user sends the query to db and gets the column data "<query>" and "<columnName>"
    And user saves the DB data to correspondent files
    Then user validates DB data

      Examples: DB data manipulation
        | query                     | columnName |
        | select * from jhi_user    | ssn        |