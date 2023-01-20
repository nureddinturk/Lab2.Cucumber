Feature: Add Tariff Plan functionality

##Guru99 Task - Share a github link for this
####You need to create new feature file new step definition and also implement page object model for that homework.
Scenario:Verify user can add a Tariff Plan
Given user is on landing page
And user clicks to Add Tariff Plan
And verified that "Add Tariff Plans" header is shown
When The user wants to Add Tariff Plan details as
| Monthly Rental| 10|
| Free Local Minutes| 12|
| Free International Minutes| 13|
| Free SMS Pack| 15|
| Local Per Minutes Charges| 18|
| International Per Minutes Charges| 25|
| SMS Per Charges| 28|
And user clicks to submit
Then user should get a message as "Congratulation you add Tariff Plan"

  Scenario:Verify user cannot add a Tariff Plan without submitting all information
    Given user is on landing page
    And user clicks to Add Tariff Plan
    And verified that "Add Tariff Plans" header is shown
    When The user wants to Add Tariff Plan in limited details as
      | Monthly Rental| 10|
      | Free Local Minutes| 12|
      | Free International Minutes| 13|
      | Free SMS Pack| 15|
      | Local Per Minutes Charges| 18|
    And user clicks to submit
    Then user should get a message as "Congratulation you add Tariff Plan"