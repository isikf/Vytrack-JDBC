@login
Feature: User should be able to login

  Background:
    Given the user is on the login page

  Scenario Outline: Login as a valid <userType>
    When the user enters "<userType>" credentials
    Then the user should be able to login

    Examples:
      | userType      |
      | store manager |
      | driver        |
      | sales manager |