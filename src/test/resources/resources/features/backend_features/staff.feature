Feature: Staff API
@Api
@ApiStaffGetRequest
Scenario: send a get request for Staff
Given user sets the "staff" and generates the token
And user sends the get request and gets the response
When user deserializes the data
And user puts the data into correspondent files
Then user validates the registrants