@us12_login_check_validity

Feature: US04_login_validity_check

  #@UIlogin
  Scenario Outline: TC01andTC03_user_login_as_admin_checks_remember_me

    Given user navigates to landing page
    Then admin click sign in button
    And admin enters username "<admin_username>"
    And admin user enters password "<admin_password>"
    And admin clicks remember me button
    And admin clicks on login button
    And admin checks administration menu exist
    Then admin logs out the page
    And  admin click sign in button
    Then checkbox of remember me
    And user verifies if username and password area is filled
    Then admin clicks cancel button

    Examples: test data
      | admin_username | admin_password |
      | great          | Ab12345.       |

  Scenario Outline: TC01_user_login_as_staff

    Given user navigates to landing page
    Then admin click sign in button
    And  admin enters username "<staff_username>"
    And admin user enters password "<staff_password>"
    And admin clicks on login button
    And staff goes to My Pages and Search Patient
    And staff searches a patient with "<patient_ssn>"
    And staff clicks edit and verify "<patient_name>" and "<patient_surname>"
     Then staff logs out the page


    Examples: test data
      | staff_username | staff_password | patient_ssn | patient_name | patient_surname |
      | staff1         | Ab12345.       | 123-56-9424 | Margie       | Hahn            |

  Scenario Outline: TC01_user_login_as_doctor

    Given user navigates to landing page
    Then admin click sign in button
    And  admin enters username "<doctor_username>"
    And admin user enters password "<doctor_password>"
    And admin clicks on login button
    And doctor goes to My Pages and verify Appointments
    Then doctor logs out the page

    Examples: test data
      | doctor_username | doctor_password |
      | doctor1        | Ab12345.       |

  Scenario Outline: TC04_user_login_as_admin_failed_login

    Given user navigates to landing page
    Then admin click sign in button
    And admin enters username "<admin_username>"
    And admin user enters password "<admin_password>"
    And admin clicks on login button
    And admin checks login failed message
    And   admin click register a new account
    Then admin verifies registration text

    Examples: test data
      | admin_username | admin_password |
      | great          | Ab12345..      |

