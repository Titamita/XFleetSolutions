Feature: Users should be able to filter vehicle table under Fleet-Vehicle page

  Background: User is already in the log in page
    Given the user is on the login page

  @B30G10-173 @wip
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


  @B30G10-174 @wip
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


  @B30G10-175 @wip
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


    #-----------------------------------------------------------------------------
    # CREATED EXTRA ACCEPTANCE CRITERIA BELOW

  @wip
  Scenario Outline: Validate the Manage Filters menu contains the following filters:
    #License Plate - Tags - Driver - Location - Chassis Number - Model Year - Last Odometer -
    #Immatriculation Date - First Contract Date - Catalog Value (VAT Incl.) - Seats Number -
    #Doors Number - Color - Transmission - Fuel Type - CO2 Emissions - Horsepower - Horsepower Taxation -
    #Power (KW)
  Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    And user clicks on Filter icon
    And user clicks on Manage Filter button
    Then Manage Filter should contain the following filters
      | License Plate             |
      | Tags                      |
      | Driver                    |
      | Location                  |
      | Chassis Number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emissions             |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power (KW)                |

    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |

