Feature: Super Admin creates Users
@create
  Scenario: The user creates users
    Given user "SUPER_ADMIN" creates "MODERATOR"
    When verify if the successful "MODERATOR"

@get
  Scenario: The user get Users with Id
    Given user logs in as "SUPER_ADMIN" and gets user by "754"
    When verify if the successful "MODERATOR"

@put
  Scenario: The user put Users with Id
    Given user logs in as "SUPER_ADMIN" and put user by "754" "MODERATOR"
    When verify if the delete successful

@delete
    Scenario: The user delete Users with Id
      Given user logs in as "SUPER_ADMIN" and deletes user by "754"
      When verify if the delete successful


