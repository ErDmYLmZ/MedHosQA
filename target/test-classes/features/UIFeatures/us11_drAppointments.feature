@us11
@UIlogin
Feature: Login for Doctor


  Background:

#    Given user navigates to lending page "https://medunna.com" used hooks class for lending page
    And user navigates to sign in portal
    And user clicks on sign in button
    When user provides the username as "doctor1"
    And user provides the password as "Ab12345."
    Then user clicks on login button
    Given clicks the my pages button
    And click my appointments button
    And click Edit button
    Then verify Edit page is opened

  Scenario:TC_01

    Then verify doctor should be able to see patient's id,start and end date,Status,Physician and patient


    @s2
  Scenario:TC_02

    And Type in fields Anamnesis "past surgical history" ,Treatment "Tonsillectomy",Diagnosis "recurrent tonsillitis"
    Then Verify doctor can type the fields "past surgical history","Tonsillectomy","recurrent tonsillitis"




  Scenario: TC03_negative
    And Don't type in Anamnesis,Treatment,Diagnosis
    Then Verify there should be an error message

  Scenario: TC_04
    Given Don't Type in prescription and description fields
    And click save button
    Then Verify appointment is saved

  Scenario: TC_05
    Given Click the status dropdown
    And  select status type
    Then Verify status type is selected.

  Scenario: TC_06 negative
    And  select status type "UNAPPROVED"
    Then verify status type  shouldn't be selected.