Feature: Login page feature

  @login    @Regression   @Sanity
  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username
    And user enters password
    And user clicks on Login button
    Then desired page URL should be displayed

  @login    @Regression
  Scenario: Login with incorrect credentials
    Given user is on login page
    When user enters wrong username
    And user enters wrong password
    And user clicks on Login button
    Then desired page URL should be displayed for unsuccessful login
