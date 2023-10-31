@filterVehicle
Feature: Users should be able to filter vehicle table under Fleet-Vehicle page

  Background: User is already in the log in page
    Given the user is on the login page

  Scenario Outline: Manage Filter button verification
    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    And user clicks on Filter icon
    Then Manage Filter button should be visible

    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |



