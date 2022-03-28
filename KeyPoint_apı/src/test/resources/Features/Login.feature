Feature: Login
@login1
  Scenario: The user logs valid in with the desired role
    Given user logs in with "SUPER_ADMIN"
    When verify if the login successful

