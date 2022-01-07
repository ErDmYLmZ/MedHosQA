#@UIlogin
#@UIStaffpage
#Feature: Manipulate staff page's data
#  Background:
#    Given login with "admin" account
#    And admin navigate page "staff"
#
#  Scenario: Register with valid ssn id
#    And admin click "Create a new Staff"
#    When user enter valid existing ssn id "128-65-1234"
#    And check the checkbox of  "Use search"
#    Then the related staff will appear in the form
#    Then admin will get toastify success message
#    And enter all fields
#    And click save
#    Then verify if it is registered
#
#  Scenario: Check with invalid ssn id
#    And admin click "Create a new Staff"
#    When user enter valid existing ssn id "564-34-1111"
#    And check the checkbox of  "Use search"
#    Then admin will get toastify failure message
#
#
#
#
#
#
#
#
#
