Feature: All appointments data to be tested

  @Api
  @Appointments
  Scenario: appointments data to be tested
    Given user generates the token
    And user sends appointments get request
    When user deserializes the appointment data
    And user saves the appointment data into correspondent files
    Then user validates the appointment