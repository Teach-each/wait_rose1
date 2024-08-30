@tag
Feature: Validate Beverages section of Wait_Rose
  This feature will cover scenarios related to the Beverages section.

  Background: Browser launch condition
    Given I launch the browser "Browser"
    Then Launch the Browser "APP_URL"

  @WR1
  Scenario Outline: User wants to login to the wait rose application
    And user enters the "<username>" and "<password>" and click on signin and validate "<err>" from file "<file>"
    Then user validates the dashboard "<Title>" along with the information for "<report>"

    Examples: 
      | username                | password | err                      | file       | Title | report                                          |  |
  #   |                         | Raj@1993 | Not_entering_email       | login_page |       |                                                 |  |
  #    | rsjayabalan06@gmail.com |          | Not_enetering_Password   | login_page |       | Login is sucessfull and dash board is validated |  |
   #  | rsjayabalan19@gmail.com | Raj@1993 | invalid_Username         | login_page |       |                                                 |  |
   #  | rsjayabalan06@gmail.com | Raj@1992 | invalid_password         | login_page |       |                                                 |  |
   #  | rsjayabalan06           | Raj@1993 | Enter_valid_email        | login_page |       |                                                 |  |
     | rsjayabalan18@gmail.com | Raj@1993 | valid_email_and_password | login_page | Login | Login is sucessfull and dash board is validated |  |
