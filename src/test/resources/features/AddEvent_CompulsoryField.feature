@AddEvent_US147
Feature: As a store manager and sales manager, I should be able to add an event

  Background: User is already in the log in page
    Given the user is on the login page

  @AC1_AccessToAddEventPage @B30G10-177
  Scenario Outline: User should access the "Add Event" page from the "General Information" page
      #(by clicking on any vehicle/row under Fleet-Vehicle module)
    Given the user logged in as "<userType>"
    When user hover over on Fleet button and click Vehicle button
    And click on vehicle row
    Then user should access the Add Event page
    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |

  @AC2_AddEventButton @B30G10-178
  Scenario Outline: Sales Manager and Store manager can click "Add Event" button,
  but Driver can NOT see "Add Event" button
    Given the user logged in as "<userType>"
    When user hover over on Fleet button and click Vehicle button
    And click on vehicle row
    Then "<userType>" can click Add Event button, but driver can NOT see Add Event button
    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |

  @AC3_AddEventPopUp @B30G10-179
  Scenario Outline: After user clicking on Add event button, Add Event page should pop up
    Given the user logged in as "<userType>"
    When user hover over on Fleet button and click Vehicle button
    And click on vehicle row
    And "<userType>" click Add Event button
    Then Add Event page should pop up
    Examples:
      | userType      |
      | sales manager |
      | store manager |

  @AC4_AddEventPopUp @B30G10-180
  Scenario Outline: Compulsory fields are shown as below:
  -> Title -> Owner -> Organizer display name -> Organizer email -> Start -> End
    Given the user logged in as "<userType>"
    When user hover over on Fleet button and click Vehicle button
    And click on vehicle row
    And "<userType>" click Add Event button
    Then Compulsory fields are shown in certain order: "<expectedReqFields>"
      | Title                  |
      | Owner                  |
      | Organizer display name |
      | Organizer email        |
      | Start                  |
      | End                    |
    Examples:
      | userType      |
      | sales manager |
      | store manager |

  @AC5_CompulsoryField @B30G10-181
  Scenario Outline: If any compulsory field is not filled, "This value should not be blank."
  message should be displayed after clicking on save button
    Given the user logged in as "<userType>"
    When user hover over on Fleet button and click Vehicle button
    And click on vehicle row
    And "<userType>" click Add Event button
    Then if any compulsory field is not filled, "This value should not be blank." message should be displayed after clicking on save button
    Examples:
      | userType      |
      | sales manager |
      | store manager |