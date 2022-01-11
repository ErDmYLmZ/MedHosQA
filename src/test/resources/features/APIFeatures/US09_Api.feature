Feature: User_Should_Validate_All_Patient_Info_API

  @Api
  Scenario: send a get request for Patients
    Given user generates current token
    And user sends the get request for patients and gets the response
    When user deserializes the patient data
    And user puts the patients data into correspondent files
#    Then user validates the patients

