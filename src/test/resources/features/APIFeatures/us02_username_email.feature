
Feature:User API
  Background:UserName Email data
    Given user set the url and generate the token
    And user send the get request and gets the response
    When user deserialize the data in to java
    And user save the data into correspondent file

@Api
@TC07_UserName
  Scenario: send a get request for username
  Then user validate the usernames

@TC08_Email
  Scenario: send a get request for email
    Then user validate the email


#  @Api
#  @RegisterNewUser
#
#  Scenario: Create a new registrant using api
#    Given user provides their user information
#    And user sends the post request
#    Then user validates