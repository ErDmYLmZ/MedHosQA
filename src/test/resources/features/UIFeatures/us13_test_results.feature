@TestResults
Feature: My Appointments / Edit / Test Results by Physician (Doctor)

  @Background
  Scenario Outline: Appointment-Edit Functionality
    Given user goes to website with "<url>"
    And user click to sign in dropdown by clicking human icon at the top of the right
    And user provides "<username>" and "<password>" credentials and clicks sign in button
    And user clicks My Pages tap and selects My Appointments dropdown
    And user clicks Edit button of the the patient to navigate the appointment-update page

    Examples:
      |url                     | username  | password|
      |https://www.medunna.com/| doctor1   | Ab12345.|

  @TestResult
  Scenario: Show Test result Functionality
    When user clicks  Show Test Results item
    And user clicks View Results button to navigates tests info
    Then user validates that test info is seen on the page

  @InPatient
  Scenario: InPatient functionality
    When user clicks Request Inpatient item
    Then verify the pop-up message "A new in Patient is created"
    Then close the page