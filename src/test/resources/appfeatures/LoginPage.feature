Feature: Login page feature
  @login    @Regression
  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "OrangeHRM"

  @login    @Regression
  Scenario: Forgot Password link
    Given user is on login page
    Then forgot your password link should be displayed

  @login    @Regression   @Sanity
  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "Admin"
    And user enters password "admin123"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "OrangeHRM"
