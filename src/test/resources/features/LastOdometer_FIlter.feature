Feature: As a user, I should be able to use "Last Odometer" filter under 'Fleet-Vehicles' page

  Background: User is already in the log in page
    Given the user is on the login page


  Scenario Outline: User can select "Last Odometer" filter under 'Fleet-Vehicles' page
    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    And user enables Filters  button
    And user enters : Last Odometer in searchBox
    Then user should see Last Odometer button on page

    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |

  Scenario Outline:  "Last Odometer" filter should provide the methods shown as below:	->
  Between	-> Not Between	-> Equals	-> Not Equals	-> More Than
  -> Less Than	-> Equals or More Than	-> Equals or Less Than	-> Is
  Empty	-> Is Not Empty

    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    And user enables Filters  button
    And user enters : Last Odometer in searchBox

    Then  user should see all options
      | Between             |
      | Not Between         |
      | Equals              |
      | Not Equals          |
      | More Than           |
      | Less Than           |
      | Equals Or More Than |
      | Equals Or Less Than |
      | Is Empty            |
      | Is Not Empty        |


    Examples:
      | userType      |
      | driver        |
      | sales manager |
      | store manager |


  Scenario Outline: Entering Both Minimum and Maximum Values
  agile :3- When user selects "Between" method with numeric values,
  the results should be between the specified values

    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    And user enables Filters  button
    And user enters : Last Odometer in searchBox

    And I enter the value into the "<minimum value>" and "<maximum value>" in filter:


    Then the page should only contain results in range of"<minimum value>" and "<maximum value>"

    Examples:
      | userType      | minimum value | maximum value |
      | driver        | 10            | 1500          |
      | driver        | 200           | 2500          |
      | driver        | 5100          | 51500         |
      | sales manager | 10            | 80000         |
      | sales manager | 200           | 80000         |
      | sales manager | 5000          | 180000        |
      | store manager | 10            | 1000          |
      | store manager | 1000          | 10000         |
      | store manager | 10000         | 1000001       |




  Scenario Outline:  4-  Methods ("Between","Equals","More Than","Less Than") shouldn't accept non numeric values
  Agile : the results should not update.?

    Given the user logged in as "<userType>"
    And user clicks on Fleet Module and select Vehicles from dropdown
    And user enables Filters  button
    And user enters : Last Odometer in searchBox

    And  user selects any of the filter "<options>" and enters any  non-digit "<data>" in filter range fields
   # Then the results should not update


    Examples:

    #ASK ABOUT THIS DATA : FOR BETWEEN WE HAVE 2 FIELDS
      | userType      | options   | data |

      | driver        | Between   | A123 |
      | driver        | Between   | !@#$ |
      | driver        | Between   | 1aBC |


      | driver        | Equals    | A123 |
      | driver        | Equals    | !@#$ |
      | driver        | Equals    | 1aBC |


      | driver        | More Than | A123 |
      | driver        | More Than | !@#$ |
      | driver        | More Than | 1aBC |

      | driver        | Less Than | A123 |
      | driver        | Less Than | !@#$ |
      | driver        | Less Than | 1aBC |


      | sales manager | Between   | A123 |
      | sales manager | Between   | !@#$ |
      | sales manager | Between   | 1aBC |


      | sales manager | Equals    | A123 |
      | sales manager | Equals    | !@#$ |
      | sales manager | Equals    | 1aBC |


      | sales manager | More Than | A123 |
      | sales manager | More Than | !@#$ |
      | sales manager | More Than | 1aBC |

      | sales manager | Less Than | A123 |
      | sales manager | Less Than | !@#$ |
      | sales manager | Less Than | 1aBC |


      | store manager | Between   | A123 |
      | store manager | Between   | !@#$ |
      | store manager | Between   | 1aBC |


      | store manager | Equals    | A123 |
      | store manager | Equals    | !@#$ |
      | store manager | Equals    | 1aBC |


      | store manager | More Than | A123 |
      | store manager | More Than | !@#$ |
      | store manager | More Than | 1aBC |

      | store manager | Less Than | A123 |
      | store manager | Less Than | !@#$ |
      | store manager | Less Than | 1aBC |