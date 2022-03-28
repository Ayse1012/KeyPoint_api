Feature: Moderator Controller POJO

  Scenario: Create a Moderator Pojo
    Given by "SUPER_ADMIN" creates by pojo
    When verify Pojo if the login successful "201"

  Scenario: user get Users with Id
    Given "SUPER_ADMIN" gets user by "122"
    When verify if the login successful "200"
