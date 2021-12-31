Feature: Registrant API
  @Api
  @ApiRegistrantGetRequest
  Scenario: send a get request for Registrants
    Given user sets the url and generates the token
    And user sends the get request and gets the response
    When user deserializes the data
    And user puts the data into correspondent files
    Then user validates the registrants