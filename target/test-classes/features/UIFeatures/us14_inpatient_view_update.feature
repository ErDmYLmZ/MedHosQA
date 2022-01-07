@Inpatient_view_update
  Feature: View / Edit Inpatients by Physician (Doctor)
    @doctor_login
    Scenario Outline: login as doctor

      Given user navigates to landing page "<url>"
      And user navigates to sign in portal
      And user clicks on sign in button
      When user provides the username as "<username>"
      And user provides the password as "<password>"
      Then user clicks on login button

      Examples: all data
        |url|username|password|
        |https://medunna.com|doctor1|Ab12345.|

      @TC001_view_inpatient_data
      Scenario: Doctor can view all inpatient info
        Given user navigates to My Inpatients page
        Then verify that doctor can view all inpatient data

    @TC002_update_inpatient_data_valid_data
    Scenario: Doctor can update all inpatient data with valid data
      Given user clicks edit button on inpatients page "xpathOfEdit"
      And user updates start date
      And user clicks on save button on edit inpatient page
      Then user views success message
      And validate that the data is updated
#      Given user clicks edit button on inpatients page

#      And user updates end date
#      And user clicks on save button on edit inpatient page
#      Given user clicks edit button on inpatients page
#      And validate that end date is updated
#      Given user clicks edit button on inpatients page
#
#      And user updates Description
#      And user clicks on save button on edit inpatient page
#      Given user clicks edit button on inpatients page
#      And validate that Description is updated
#      Given user clicks edit button on inpatients page
#
#      And user updates Created Date
#      And user clicks on save button on edit inpatient page
#      Given user clicks edit button on inpatients page
#      And validate that Created Date is NOT updated
#      Given user clicks edit button on inpatients page

#    @TC003_update_inpatient_data_invalid_data
#    Scenario: Doctor can not update all inpatient data with invalid data?
#
#      @TC004_update_status
#      Scenario Outline: Doctor can update status
#      Given user clicks edit button on inpatients page
#      And user updates Status as "<status>"
#      And user clicks on save button on edit inpatient page
#      Given user clicks edit button on inpatients page
#      And validate that Status is updated as "<status>"
#
#
#        Examples:
#          | status |
#          | UNAPPROVED |
#          | STAYING |
#          | DISCHARGED |
#          | CANCELLED |
#
#
#        @TC005_update_room
#        Scenario: doctor can update room
#
#        Given user clicks edit button on inpatients page
#        And user updates ROOM
#        And user clicks on save button on edit inpatient page
#        Given user clicks edit button on inpatients page
#        And validate that ROOM is updated



