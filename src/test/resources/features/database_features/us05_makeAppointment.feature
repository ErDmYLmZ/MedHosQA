Feature: DB user data test

 Background:
   Given user create a connection with DB using "jdbc:postgresql://medunna.com:5432/medunna_db", "medunnadb_user" and "Medunnadb_@129"

   @DBtesting
   Scenario Outline: Database testing
     Given user sends to query to db and gets the column data "<query>" and "<columnName>"
     And user saves the DB data to correspondent files for appointment
     Then user validates DB data for appointment

   Examples: DB data manipulation
     |query|columnName|
     |select * from appointment|id|