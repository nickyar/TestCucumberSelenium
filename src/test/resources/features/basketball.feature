Feature: Basketball

  Scenario: Successful Registration
#    Given I use "Chrome" as a browser
    Given I use "Edge" as a browser
    And I navigate to basketball website "https://membership.basketballengland.co.uk/NewSupporterAccount"
    When I enter my date of birth "20/03/2000"
    And I enter my first name "Nick"
    And I enter my last name "Ghadiri"
    And I enter my email address "ghad6@gmail.com"
    And I confirm my email address "ghad6@gmail.com"
    And I enter my password "123QWEasd"
    And I confirm my password "123QWEasd"
    And I tick Terms and Conditions
    And I tick I am adult
    And I tick code of ethics
    When I press submission button
    Then Registration is complete


  Scenario Outline: Negative Registration Tests
    Given I use "<browser>" as a browser
    And I navigate to basketball website "https://membership.basketballengland.co.uk/NewSupporterAccount"
    When I enter my date of birth "<dateOfBirth>"
    And I enter my first name "<firstName>"
    And I enter my last name "<lastName>"
    And I enter my email address "<email>"
    And I confirm my email address "<confirmEmail>"
    And I enter my password "<password>"
    And I confirm my password "<confirmPassword>"
    And I tick Terms and Conditions
    And I tick I am adult
    And I tick code of ethics
    When I press submission button
    Then I should see error message "<errorMessage>"

    Examples:
      | browser | dateOfBirth | firstName | lastName  | email             | confirmEmail       | password  | confirmPassword | errorMessage                         |
      | Edge    | 20/03/1985  | Nick      |           | test2@example.com | test2@example.com  | 123QweAsd | 123QweAsd       | Last Name is required                |
      | Chrome  | 20/03/1985  | Adam      | Johansson | test3@example.com | wrong2@example.com | 123QweAsd | 123QweAsd       | Confirm Email Address does not match |
      | Chrome  | 20/03/1985  | John      | Avaltsson | test3@example.com | test3@example.com  | 123QweAsd | NoPass          | Password did not match               |
