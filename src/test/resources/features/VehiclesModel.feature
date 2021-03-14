Feature: Vehicle model page
@db
  Scenario Outline: Vehicles model test with <modelName>
    Given the user is on the login page
    When the user enters "store manager" credentials
    Then the user should be able to login
    When the user navigates to "Fleet" "Vehicles Model"
    When the user clicks the "<modelName>" from vehicles model
    Then the information "<modelName>" should be same with database

    Examples:
    |modelName|
    |zamazingo|
    |Mazda    |
    |Rouge    |


