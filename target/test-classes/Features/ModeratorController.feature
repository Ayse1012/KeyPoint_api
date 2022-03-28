Feature: Moderator Controller

  Scenario: Create a Moderator
    Given by "SUPER_ADMIN" creates "MODERATOR"
    When verify if the login successful "201"

  @get
  Scenario: user get Users with Id
    Given "SUPER_ADMIN" gets user by "117"
    When verify if the login successful "200"

  @put
  Scenario: user put Users with Id
    Given "SUPER_ADMIN" put user by "117"
    When verify if the login successful "204"
