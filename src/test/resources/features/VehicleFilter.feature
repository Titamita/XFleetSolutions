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

  @wipjd
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


  @B30G10-210 @wipnew
    #Worked on as an additional US-154 for extra practice ==> AC1 and AC2
  Scenario Outline: User should be able to use Tags filter under Fleet-Vehicles page
    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    And user clicks on Filter icon
    And user clicks on Manage Filter button
    When user select Tags filter from dropdown option
    And  user clicks on Tags All filter
    Then Tags filter should provide the methods in a dropdown option as shown below
      | Is Any Of     |
      | Is Not Any Of |

    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |



    @B30G10-211 @wipnew
      #US-154 / AC3 for extra practice
  Scenario Outline: User should be able to use Tags filter under Fleet-Vehicles page
    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    And user clicks on Filter icon
    And user clicks on Manage Filter button
    When user select Tags filter from dropdown option
    And  user clicks on Tags All filter
    And user selects Is Any Of method with Compact option and clicks Update
    Then table should contain Compact Tags only

    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |



        # Negative Testing - invalid login - this should be under Login.feature page which I don't have


  Scenario Outline: Login with invalid credentials
    #Given the user is on the login page
    When the user login with "<username>" and "<password>"
    Then user should not be able to log in

    Examples:
      | username        | password      |
      | abcd            | UserUser123   |
      | salesmanager101 | abcd          |
      | xyz             | wrongPassword |
      | wrongUserName   | empty         |