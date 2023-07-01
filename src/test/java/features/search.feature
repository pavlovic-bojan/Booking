Feature: Search
  As a user I should be able to search for hotel or apartment

  @Smoke
  Scenario Outline: Search in desired destination for hotel or apartment
  As a user I shouldn't be able to search for hotel or apartment

    Given I am on the booking home page
    When I enter my desired destination "<destination>"
    And Choose the duration of the stay
    And Choose number of guests and rooms
    And Click Search
    Then Verify that the search results are displayed

    Examples:
      | destination |
      | kopaonik    |
      | zlatibor    |
      | zlatar      |
      | brezovica   |
      | novi sad    |
      | beograd     |