@us12_doctor_request

Feature: US12 Doctor request a test

  @UIlogin
  Scenario Outline: TC01 Doctor clicks request a test button

    Given Doctor goes to url
    And Doctor navigates to sign in page
    And Doctor clicks on sign in button
    And Doctor enters username "<username>"
    And Doctor enters password "<password>"
    And Doctor clicks sign in button
    And Doctor clicks My Pages dropdown and clicks My Appointments
    And Doctor clicks Edit button of the patient and navigates to Create or Edit Appointments page
    And Doctor clicks Request a test item
    Then Doctor navigates to Test Items page and verifies the text of the page

    Examples: test data
      | username | password |
      | doctor1  | Ab12345. |

    Scenario: TC02 Doctor puts checkmarks on the test items
    Given Doctor is on the Test Items Page
    And Doctor puts checkmark to the options "Glucose", "Urea", "Creatinine", "Sodium", "Potassium", "Total protein", "Albumin", "Hemoglobin"
    And Doctor clicks save button
    Then Doctor verifies success message and Create or edit an Appointment text as navigates back to that page