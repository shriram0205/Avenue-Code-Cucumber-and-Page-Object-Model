Feature: Authentication

Scenario: Successfully logging in
    Given the avenue code home page
    When logging in as an user
    Then the home page navigation is available