Feature: US_09_View_Edit_And_Delete_Patient_Information

  Background: Login

  @UIlogin

  Scenario: TC_0001_View_Patient_Information_Navigating_To_View_Portal

    Given user navigates to sign in portal
    And user sign in as a staff
    When user navigates to patients under MY PAGES dropdown
    Then verify the patient page



  Scenario: TC_0002_Staff_Should_Have_To_Search_The_Applicant_By_Their_SSN

    Given user navigates to search patients under my pages dropdown
    And enter a valid ssn number to patient ssn box
    And user selects a patient and clicks to view button
    Then user verify all the necessary field is displayed


    Scenario: TC_0003_Staff_should_have_to edit_patient_information
      Given user navigates to search patients under my pages dropdown
      And enter a valid ssn number to patient ssn box
      Given  enter a valid ssn number to patient ssn box
      And user selects a patient and clicks to edit button
      And user verifies display patient all information
      When user clicks to firstname box the system should allow to update the firstname
      When user clicks to lastname box the system should allow to update the lastname
      When user clicks to birthdate box the system should allow to update the birtdate
      When user clicks to email box the system should allow to update the email
      When user clicks to phone box the system should allow to update the phone
      When user clicks to gender dropdown the system should allow to update the gender
      When user clicks to blood group dropdown the system should allow to update the blood group
      When user clicks to address box the system should allow to update the address
      When user clicks to description box the system should allow to update the description
      When user clicks to user dropdown the system should allow to update the user
      When user clicks to country dropdown the system should allow to update the country
      When user clicks to state and city dropdown the system should allow to update the state and city
      When user click on save button
      Then verify successfully editing patient information


  @UIlogin
  Scenario: TC_0004_Staff_Should_Not_Have_To_Delete_Patient

    Given user navigates to sign in portal
    And user navigates to patients under MY PAGES dropdown
    Then verify there is no delete button




  @UIlogin
  Scenario Outline:TC_0005_Admin_Should_Not_Have_To_Search_Patient_By_Their_SSN / TC_0006_Admin_Can_Delete_Any_Patient_Info

    Given user navigates to sign in portal
    And user clicks on sign in button
    When user provides the username as "<username>"
    And user provides the password as "<password>"
    Then user clicks on login button
    And admin navigates to patient page under the Items&Titles dropdown
    Then verify there is no search box
    When user selects the patient to delete and clicks on Delete button
    Then verify user successfully deleted
    Examples: all data
      | username | password |
      | great    | Ab12345. |





