Feature: Dashboard page feature

Background:
  Given user has already logged into application
  |username|password|
  |Admin|admin123|

@dashboard    @Regression
Scenario: Dashboard page title
  Given user is on dashboard page
  Then user gets the title of the page
  Then page title should be "OrangeHRM"

  @dashboard    @Regression
Scenario: Cart icon is visible
  Given user is on dashboard page
  Then dashboard icon should be visible

