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






