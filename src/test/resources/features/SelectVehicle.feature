@us152
Feature: Selection of vehicle functionality verification

  Background: User is already in the log in page
    Given the user is on the login page

  Scenario Outline: Verifying all the checkboxes unchecked
    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    Then user sees all the checkboxes are unchecked

    Examples:
      | userType      |
      | sales manager |
      | store manager |


  Scenario Outline: Verify the first checkbox is selected
    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    Then user selects the first checkbox to check all the cars

    Examples:
      | userType      |
      | sales manager |
      | store manager |


  Scenario Outline: Verifying any car can be selected
    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    And user clicks on any checkbox and it is enabled and clickable
    Then user is able to select any car by clicking on a checkbox

    Examples:
      | userType      |
      | sales manager |
      | store manager |








