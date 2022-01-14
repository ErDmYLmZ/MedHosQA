Feature: All appointments data to be tested

  @Api
  @appointments
  Scenario: appointments data to be tested
    Given user generates token
    And user sends appointments get request
    When user deserializes the appointment data
    When user saves the appointment data into correspondent files
