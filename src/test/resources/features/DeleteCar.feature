
Feature: As a 'Sales Manager' and 'Store Manager', should be able to delete a car

  Background: User is already in the log in page
    Given the user is on the login page


  Scenario Outline: Verify users can sees the delete button
    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    Then user hovers over the three dots at the end of each row and sees delete icon appear

    Examples:
      | userType      |
      | sales manager |
      | store manager |
      | driver        |


  Scenario Outline: Display Delete Confirmation Pop-up
    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    And user hovers over the three dots at the end of each row and sees delete icon appear
    And the user clicks on the delete button
    Then Delete Confirmation pop-up is displayed

    Examples:
      | userType      |
      | sales manager |
      | store manager |
      | driver        |


  Scenario Outline: Verify 'You do not have permission' message is displayed
    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    And user hovers over the three dots at the end of each row and sees delete icon appear
    And the user clicks on the delete button
    And the user confirms deletion by clicking on "Yes, Delete" button
    Then a "You do not have permission to perform this action" message is displayed

    Examples:
      | userType|
      | driver  |

  @carDeletion
  Scenario Outline: Verify 'Item deleted' message is displayed for Sales Manager and Store Manager
    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    And user hovers over the three dots at the end of each row and sees delete icon appear
    And the user clicks on the delete button
    And the user confirms deletion by clicking on "Yes, Delete" button
    Then an "Item deleted" message is displayed

    Examples:
      | userType      |
      | sales manager |
      | store manager |
