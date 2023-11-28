@OpenWeather
Feature: Open Weather App - Random Tests

  Scenario: Verify the user can retrieve a list of all dog breeds
    Given The user has requested the list of all dog breeds
    Then Verify retriever breed is within the list


  Scenario: Verify the user can retrieve a list of sub-breeds for retriever
    Given The user has requested the list of sub-breeds for retriever
    Then Verify sub-breeds for retriever breed is within the list

  Scenario: Verify the user can retrieve a list of sub-breeds for retriever
    Given The user has requested the list of sub-breeds for retriever
    Then Verify sub-breeds for retriever breed is within the list