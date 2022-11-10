Feature: homepage

  Background: navigate to homepage
    Given user on TestPage

  Scenario: verify homepage
    Given click on logo button
    Then verify homepage
    And click on address
    Then click on contactMail

  Scenario: verify languages
    And click on flags

  Scenario: fill out contact form
    And user goes to Contact page
    And fill out form
    Then submit the form
    Then verify form sent

  Scenario: play and slide the video
    Then scroll down
    And click on video
