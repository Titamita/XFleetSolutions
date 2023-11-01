@AddEvent_US147
Feature: As a store manager and sales manager, I should be able to add an event

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