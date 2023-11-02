@US-156
Feature: Users should be able to filter vehicle table under Fleet-Vehicle page

  Background: User is already in the log in page
    Given the user is on the login page

    @AC1_JD
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


      @AC2_JD
    Scenario Outline: User can apply filters by clicking on any filter name under Manage Filters menu
      Given the user logged in as "<userType>"
      And user clicks on Fleet Module and select Vehicles from dropdown
      And user clicks on Filter icon
      And user clicks on Manage Filter button
      When user can select any "<checkbox>" from dropdown options

      Examples:
        | userType      | checkbox |
        | driver        | Tags     |
        | sales manager | Driver   |
        | store manager | Location |


        @AC3_JD
      Scenario Outline: User can find a filter by typing the filter name under Manage Filters menu
        Given the user logged in as "<userType>"
        And user clicks on Fleet Module and select Vehicles from dropdown
        And user clicks on Filter icon
        And user clicks on Manage Filter button
        Then user type "model year" in the Manage Filter search box
        When user should see "Model Year" as available filter

        Examples:
          | userType      |
          | driver        |
          | sales manager |
          | store manager |



