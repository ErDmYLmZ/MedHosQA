Feature: Create new Physicians / Update existing Physicians / View and Delete Physicians by admin

  Background:Physician info
  Scenario Outline: Admin can access and do create,update,view,delete functionalities on all physicians' info
    Given user goes to the website with "<url>"
    And admin should click to sign in dropdown by clicking humon icon at the top of the right
    And admin provides "<username>" and "<password>" credentials and clicks sign in button
    And admin clicks on items&titles dropdown
    And admin clicks on physician


    Examples:
      |url                     | username  | password|
      |https://www.medunna.com/| great   | Ab12345.|

    @TC_0001
    Scenario: Admin can choose/search an existing registered person by SSN id
    When admin clicks on Create a new Physician button
    And admin enters an existing SSN id in SSN box
    Then admin clicks on Search user and verifies the pop-up message as an "User found with search SSN"

    @TC_0002
    Scenario: Their info should be populated firstname, lastname birth date etc..
    When admin clicks on Create a new Physician button
    Then admin marks use search checkbox and verifies the doctor's info such as firstname, lastname,birth date etc. is populated

    @TC_0003
    Scenario: Admin should provide a specialty for the Doctor
    When admin clicks on Create a new Physician button
    Then admin types a specialty in the Speciality Box for the doctor and verifies the physician's specialty is provided

    @TC_0004
    Scenario: Admin can provide a profile picture of the doctor
    When admin clicks on Create a new Physician button
    Then admin clicks on Choose file Button and uploads the picture for the doctor and verifies the physician's image is provided

#      @TC_0005
#    Scenario: Admin should choose the doctor among existing users
#      When ???

      @TC_0006
      Scenario: Admin should provide the Exam fee of the doctor (earning amount)
      When admin clicks on Create a new Physician button
      Then admin clicks on Exam Fee Box and types an amount of exam fee of the doctor and verifies the exam fee is provided

      @TC_0007
      Scenario: Admin can view all Physicians' info populated on view portal
      Then admin clicks on view portal and and verifies all Physicians' info populated on view portal

      @TC_0008
      Scenario: Admin can edit existing Physicians' info using new data
      When admin clicks on edit portal
      Then admin types new data for existing Physicians' info and verifies the pop-up meassage "A physician is updated"

      @TC_0009
      Scenario: Admin can delete existing Physicians
        Then admin clicks on delete portal and verifies the pop-up meassage "A physician is deleted with identifier ####"

        @TC_0010
        Scenario: Validate all physicians using API
        When Connect with the Api
       Then Validate the data by using get request

          @TC_0011
          Scenario: Validate all physicians using DB
          When Connect the DB with the JDBC
         Then Validate the data by using Database