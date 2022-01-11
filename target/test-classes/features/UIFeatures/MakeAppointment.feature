
Feature: US_05_Make an appointment
Background: user goes the medunna hospital
  Given user goes to webpage
  And user select make an appointment button

    Scenario: TC_01_user enter firstname
      Given user enters firstname
      Then user verify the first name box is not blank

    Scenario: TC_02_user enter
      Given user enters SSN
      Then user verify the ssn box is not blank

    Scenario: TC_03_user enters lastname
      Given user enters lastname
      Then user verify the lastname box is not blank

    Scenario: TC_04_user enters email
      Given user enters email
      Then user verify the email box is not blank

    Scenario: TC_05_user enters phone
      Given user enters phone
      Then user verify the email box is not blank


    @appointment
    Scenario: TC_06_user
       Given user enters firstname
       And user enters SSN
       And user enters lastname
       And user enters email
       And user enters phone
       And user click send an appointment request button
       And User goes register dropdown and click register button
       And user enters same ssn
       And user enters same firstname
       And ser enters same lastname
       And user enters username
       And user enters same email
       And user enters password
       And user enters confirm password again
       And user click register button
       And user goes sign in dropdown and click sign in button
       And user enters username
       And user enters password
       And user click sign in button
       Then Verify user sees all information